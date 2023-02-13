package dev.project.eunmin.feature.calculator.basic.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.project.eunmin.core.calculator.domain.DividerUseCase
import dev.project.eunmin.core.calculator.domain.MinusUseCase
import dev.project.eunmin.core.calculator.domain.MultipleUseCase
import dev.project.eunmin.core.calculator.domain.PlusUseCase
import dev.project.eunmin.design.keyboard.basic.OperatorType
import dev.project.eunmin.feature.calculator.basic.ui.sideeffect.CalculatorScreenSideEffect
import dev.project.eunmin.feature.calculator.basic.ui.state.CalculatorScreenState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val dividerUseCase: DividerUseCase,
    private val multipleUseCase: MultipleUseCase,
    private val plusUseCase: PlusUseCase,
    private val minusUseCase: MinusUseCase
): ContainerHost<CalculatorScreenState, CalculatorScreenSideEffect>, ViewModel() {
    override val container = container<CalculatorScreenState, CalculatorScreenSideEffect>(CalculatorScreenState())

    fun numberButtonClicked(number: BigDecimal) = intent {
        reduce {
            if (state.isShowInput) {
                state.copy(
                    current = number,
                    isShowInput = false
                )
            } else {
                state.copy(
                    current = state.current.multiply(BigDecimal(10)).plus(number),
                )
            }
        }
    }

    fun deleteButtonClicked() = intent {
        reduce {
            state.copy(current = state.current.divide(BigDecimal(10)).setScale(0, RoundingMode.DOWN))
        }
    }

    fun clearButtonClicked() = intent {
        reduce {
            state.copy(
                current = BigDecimal(0),
                operatorType = OperatorType.NOTHING,
                total = BigDecimal(0),
                isShowInput = false
            )
        }
    }

    fun operatorTypeButtonClicked(operatorType: OperatorType) = intent {
        val result = if (state.operatorType != OperatorType.NOTHING) {
            calculate(operatorType, state.total, state.current)
        } else { state.current }

        reduce {
            state.copy(operatorType = operatorType, isShowInput = true, total = result, current = result)
        }
    }

    fun equalsButtonClicked() = intent {
        val result = calculate(OperatorType.NOTHING, state.total, state.current)

        reduce {
            state.copy(operatorType = OperatorType.NOTHING, isShowInput = false, total = BigDecimal(0), current = result)
        }
    }

    private suspend fun calculate(operatorType: OperatorType, first: BigDecimal, second: BigDecimal): BigDecimal =
        when(operatorType) {
            OperatorType.DIVIDER -> dividerUseCase(first, second)
            OperatorType.MULTIPLE -> multipleUseCase(first, second)
            OperatorType.PLUS -> plusUseCase(first, second)
            OperatorType.MINUS -> minusUseCase(first, second)
            OperatorType.NOTHING -> plusUseCase(first, second)
        }
}
