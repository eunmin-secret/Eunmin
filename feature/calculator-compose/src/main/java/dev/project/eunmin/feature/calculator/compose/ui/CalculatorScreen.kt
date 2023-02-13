package dev.project.eunmin.feature.calculator.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.project.eunmin.design.keyboard.compose.CalculatorKeyboard
import dev.project.eunmin.design.keyboard.compose.OperatorType
import dev.project.eunmin.design.system.compose.theme.EunminTheme
import dev.project.eunmin.feature.calculator.compose.ui.state.CalculatorScreenState
import org.orbitmvi.orbit.compose.collectAsState
import java.math.BigDecimal

@Composable
internal fun CalculatorRoute(
    viewModel: CalculatorViewModel = viewModel()
) {
    val state = viewModel.collectAsState()

    CalculatorScreen(
        state = state,
        onNumberBtnClicked = viewModel::numberButtonClicked,
        onDeleteBtnClicked = viewModel::deleteButtonClicked,
        onOperatorBtnClicked = viewModel::operatorTypeButtonClicked,
        onClearBtnClicked = viewModel::clearButtonClicked,
        onEqualsBtnClicked = viewModel::equalsButtonClicked
    )
}

@Composable
internal fun CalculatorScreen(
    state: State<CalculatorScreenState>,
    onNumberBtnClicked: (BigDecimal) -> Unit = { },
    onClearBtnClicked: () -> Unit = { },
    onDeleteBtnClicked: () -> Unit = { },
    onOperatorBtnClicked: (OperatorType) -> Unit = { },
    onEqualsBtnClicked: () -> Unit = { }
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = state.value.current.toPlainString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp)
                    .align(Alignment.BottomCenter),
                fontSize = 40.sp,
                textAlign = TextAlign.End,
            )
        }

        CalculatorKeyboard(
            operatorType = state.value.operatorType,
            onNumberBtnClicked = { number ->
                onNumberBtnClicked(number.toBigDecimal())
            },
            onDeleteBtnClicked = onDeleteBtnClicked,
            onOperatorBtnClicked = onOperatorBtnClicked,
            onClearBtnClicked = onClearBtnClicked,
            onEqualsBtnClicked = onEqualsBtnClicked
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
internal fun CalculatorScreenPreview() {
    EunminTheme {
        CalculatorRoute()
    }
}