package dev.project.eunmin.feature.calculator.basic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dev.project.eunmin.feature.calculator.basic.databinding.FragmentCalculatorBinding
import dev.project.eunmin.feature.calculator.basic.ui.sideeffect.CalculatorScreenSideEffect
import dev.project.eunmin.feature.calculator.basic.ui.state.CalculatorScreenState
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    val binding: FragmentCalculatorBinding = _binding!!

    private val viewModel by viewModels<CalculatorViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind(inflater, container)
        observe()
        return binding.root
    }

    private fun bind(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false).apply {
            keyboard.onNumberBtnClicked = {
                viewModel.numberButtonClicked(it.toBigDecimal())
            }
            keyboard.onClearBtnClicked = viewModel::clearButtonClicked
            keyboard.onDeleteBtnClicked = viewModel::deleteButtonClicked
            keyboard.onEqualsBtnClicked = viewModel::equalsButtonClicked
            keyboard.onOperatorBtnClicked = viewModel::operatorTypeButtonClicked
        }
    }

    private fun observe() {
        viewModel.observe(lifecycleOwner = viewLifecycleOwner, state = ::render, sideEffect = ::handleSideEffect)

        // Or observe the streams directly
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.container.stateFlow.collect { render(it) }
                }
                launch {
                    viewModel.container.sideEffectFlow.collect { handleSideEffect(it) }
                }
            }
        }
    }

    private fun render(state: CalculatorScreenState) {
        binding.tvResult.text = state.current.toPlainString()
        binding.keyboard.setOperatorType(state.operatorType)
    }

    private fun handleSideEffect(sideEffect: CalculatorScreenSideEffect) {

    }

}