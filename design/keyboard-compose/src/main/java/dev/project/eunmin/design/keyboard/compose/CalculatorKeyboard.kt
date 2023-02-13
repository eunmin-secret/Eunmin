package dev.project.eunmin.design.keyboard.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.project.eunmin.design.system.compose.component.KeyboardButton
import dev.project.eunmin.design.system.compose.theme.EunminTheme

@Composable
fun CalculatorKeyboard(
    operatorType: OperatorType = OperatorType.NOTHING,
    onNumberBtnClicked: (Int) -> Unit = { },
    onClearBtnClicked: () -> Unit = { },
    onDeleteBtnClicked: () -> Unit = { },
    onOperatorBtnClicked: (OperatorType) -> Unit = { },
    onEqualsBtnClicked: () -> Unit = { }
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
    ) {
        Row(Modifier.fillMaxWidth().wrapContentHeight()) {
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "AC",
                ratio = 2f,
                onClick = onClearBtnClicked
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "DE",
                ratio = 2f,
                onClick = onDeleteBtnClicked
            )
        }

        Row {
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "7",
                onClick = {
                    onNumberBtnClicked(7)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "8",
                onClick = {
                    onNumberBtnClicked(8)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "9",
                onClick = {
                    onNumberBtnClicked(9)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "÷",
                onClick = {
                    onOperatorBtnClicked(OperatorType.DIVIDER)
                },
                focus = operatorType == OperatorType.DIVIDER
            )
        }

        Row {
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "4",
                onClick = {
                    onNumberBtnClicked(4)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "5",
                onClick = {
                    onNumberBtnClicked(5)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "6",
                onClick = {
                    onNumberBtnClicked(6)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "x",
                onClick = {
                    onOperatorBtnClicked(OperatorType.MULTIPLE)
                },
                focus = operatorType == OperatorType.MULTIPLE
            )
        }

        Row {
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "1",
                onClick = {
                    onNumberBtnClicked(1)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "2",
                onClick = {
                    onNumberBtnClicked(2)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "3",
                onClick = {
                    onNumberBtnClicked(3)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "-",
                onClick = {
                    onOperatorBtnClicked(OperatorType.MINUS)
                },
                focus = operatorType == OperatorType.MINUS
            )
        }

        Row {
            KeyboardButton(
                modifier = Modifier.weight(2f),
                symbol = "0",
                ratio = 2f,
                onClick = {
                    onNumberBtnClicked(0)
                }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "=",
                onClick = onEqualsBtnClicked,
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                symbol = "+",
                onClick = {
                    onOperatorBtnClicked(OperatorType.PLUS)
                },
                focus = operatorType == OperatorType.PLUS
            )
        }
    }
}

enum class OperatorType {
    DIVIDER, MULTIPLE, MINUS, PLUS, NOTHING
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CalculatorKeyboardPreview() {
    EunminTheme {
        CalculatorKeyboard()
    }
}