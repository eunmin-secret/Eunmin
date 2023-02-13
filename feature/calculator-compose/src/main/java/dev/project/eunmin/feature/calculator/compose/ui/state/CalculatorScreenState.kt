package dev.project.eunmin.feature.calculator.compose.ui.state

import dev.project.eunmin.design.keyboard.compose.OperatorType
import java.math.BigDecimal

data class CalculatorScreenState(
    val current: BigDecimal = BigDecimal(0),
    val operatorType: OperatorType = OperatorType.NOTHING,
    val total: BigDecimal = BigDecimal(0),
    val isShowInput: Boolean = false
)