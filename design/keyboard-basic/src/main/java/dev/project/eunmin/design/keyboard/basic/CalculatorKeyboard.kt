package dev.project.eunmin.design.keyboard.basic

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import dev.project.eunmin.design.keyboard.basic.databinding.ViewKeyboardCalculatorBinding

class CalculatorKeyboard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): FrameLayout(context, attrs, defStyleAttr) {
    private val binding: ViewKeyboardCalculatorBinding

    var onNumberBtnClicked: (Int) -> Unit = { }
    var onClearBtnClicked: () -> Unit = { }
    var onDeleteBtnClicked: () -> Unit = { }
    var onOperatorBtnClicked: (OperatorType) -> Unit = { }
    var onEqualsBtnClicked: () -> Unit = { }

    private var operatorType = OperatorType.NOTHING

    init {
        binding = ViewKeyboardCalculatorBinding.inflate(LayoutInflater.from(context), this, true).apply {
            btnClear.setOnClickListener { onClearBtnClicked() }
            btnDelete.setOnClickListener { onDeleteBtnClicked() }
            btnEquals.setOnClickListener { onEqualsBtnClicked() }

            btnDivider.setOnClickListener { onOperatorBtnClicked(OperatorType.DIVIDER) }
            btnMultiple.setOnClickListener { onOperatorBtnClicked(OperatorType.MULTIPLE) }
            btnMinus.setOnClickListener { onOperatorBtnClicked(OperatorType.MINUS) }
            btnPlus.setOnClickListener { onOperatorBtnClicked(OperatorType.PLUS) }

            btn0.setOnClickListener { onNumberBtnClicked(0) }
            btn1.setOnClickListener { onNumberBtnClicked(1) }
            btn2.setOnClickListener { onNumberBtnClicked(2) }
            btn3.setOnClickListener { onNumberBtnClicked(3) }
            btn4.setOnClickListener { onNumberBtnClicked(4) }
            btn5.setOnClickListener { onNumberBtnClicked(5) }
            btn6.setOnClickListener { onNumberBtnClicked(6) }
            btn7.setOnClickListener { onNumberBtnClicked(7) }
            btn8.setOnClickListener { onNumberBtnClicked(8) }
            btn9.setOnClickListener { onNumberBtnClicked(9) }
        }
    }

    fun setOperatorType(operatorType: OperatorType) {
        this.operatorType = operatorType

        when (operatorType) {
            OperatorType.DIVIDER -> {
                binding.btnDivider.strokeWidth = 3
                binding.btnMultiple.strokeWidth = 0
                binding.btnMinus.strokeWidth = 0
                binding.btnPlus.strokeWidth = 0
            }
            OperatorType.MULTIPLE -> {
                binding.btnDivider.strokeWidth = 0
                binding.btnMultiple.strokeWidth = 3
                binding.btnMinus.strokeWidth = 0
                binding.btnPlus.strokeWidth = 0
            }
            OperatorType.MINUS -> {
                binding.btnDivider.strokeWidth = 0
                binding.btnMultiple.strokeWidth = 0
                binding.btnMinus.strokeWidth = 3
                binding.btnPlus.strokeWidth = 0
            }
            OperatorType.PLUS -> {
                binding.btnDivider.strokeWidth = 0
                binding.btnMultiple.strokeWidth = 0
                binding.btnMinus.strokeWidth = 0
                binding.btnPlus.strokeWidth = 3
            }
            OperatorType.NOTHING -> {
                binding.btnDivider.strokeWidth = 0
                binding.btnMultiple.strokeWidth = 0
                binding.btnMinus.strokeWidth = 0
                binding.btnPlus.strokeWidth = 0
            }
        }
    }
}

enum class OperatorType {
    DIVIDER, MULTIPLE, MINUS, PLUS, NOTHING
}