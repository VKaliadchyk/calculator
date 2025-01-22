package com.vk.app.calculator.ui.feature.calculator.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.app.calculator.R
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.*
import com.vk.app.calculator.ui.components.KeyboardButton
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent.*
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun SimpleCalculatorScreen(
    modifier: Modifier = Modifier,
    uiState: SimpleCalculatorScreenUiState,
    uiEvent: (SimpleCalculatorScreenUiEvent) -> Unit
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Column (
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(0.75f)
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = uiState.equation, fontSize = 36.sp)
            Spacer(Modifier.height(12.dp))
            Text(text = uiState.result, fontSize = 28.sp, color = Color.Black.copy(alpha = 0.60f))
        }
        HorizontalDivider()
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(1f).padding(vertical = 8.dp),
        ) {
            val buttonSize: Dp = 74.dp
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                KeyboardButton(
                    vectorId = R.drawable.keypad_ac,
                    size = buttonSize,
                    contentDescription = "AC key",
                    onClick = { uiEvent(KeypadKeyPress(Clear)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_del,
                    size = buttonSize,
                    contentDescription = "DEL key",
                    onClick = { uiEvent(KeypadKeyPress(Del)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_percent,
                    size = buttonSize,
                    contentDescription = "% key",
                    onClick = { uiEvent(KeypadKeyPress(Percent)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_divide,
                    size = buttonSize,
                    contentDescription = "/ key",
                    onClick = { uiEvent(KeypadKeyPress(Divide)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                KeyboardButton(
                    vectorId = R.drawable.keypad_seven,
                    size = buttonSize,
                    contentDescription = "7 key",
                    onClick = { uiEvent(KeypadKeyPress(Seven)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_eight,
                    size = buttonSize,
                    contentDescription = "8 key",
                    onClick = { uiEvent(KeypadKeyPress(Eight)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_nine,
                    size = buttonSize,
                    contentDescription = "9 key",
                    onClick = { uiEvent(KeypadKeyPress(Nine)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_multiply,
                    size = buttonSize,
                    contentDescription = "* key",
                    onClick = { uiEvent(KeypadKeyPress(Multiply)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                KeyboardButton(
                    vectorId = R.drawable.keypad_four,
                    size = buttonSize,
                    contentDescription = "4 key",
                    onClick = { uiEvent(KeypadKeyPress(Four)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_five,
                    size = buttonSize,
                    contentDescription = "5 key",
                    onClick = { uiEvent(KeypadKeyPress(Five)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_six,
                    size = buttonSize,
                    contentDescription = "6 key",
                    onClick = { uiEvent(KeypadKeyPress(Six)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_subtract,
                    size = buttonSize,
                    contentDescription = "- key",
                    onClick = { uiEvent(KeypadKeyPress(Subtract)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                KeyboardButton(
                    vectorId = R.drawable.keypad_one,
                    size = buttonSize,
                    contentDescription = "1 key",
                    onClick = { uiEvent(KeypadKeyPress(One)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_two,
                    size = buttonSize,
                    contentDescription = "2 key",
                    onClick = { uiEvent(KeypadKeyPress(Two)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_three,
                    size = buttonSize,
                    contentDescription = "3 key",
                    onClick = { uiEvent(KeypadKeyPress(Three)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_add,
                    size = buttonSize,
                    contentDescription = "+ key",
                    onClick = { uiEvent(KeypadKeyPress(Add)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "Unused key",
                    onClick = { /* TODO Implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_zero,
                    size = buttonSize,
                    contentDescription = "0 key",
                    onClick = { uiEvent(KeypadKeyPress(Zero)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_dot,
                    size = buttonSize,
                    contentDescription = ". key",
                    onClick = { uiEvent(KeypadKeyPress(Dot)) }
                )
                KeyboardButton(
                    vectorId = R.drawable.keypad_equals,
                    size = buttonSize,
                    contentDescription = "= key",
                    onClick = { uiEvent(KeypadKeyPress(Equals)) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleCalculatorScreenPreview() {
    CalculatorTheme {
        SimpleCalculatorScreen(
            uiState = SimpleCalculatorScreenUiState.defaultValue.copy(
                equation = "0 + 5",
                result = "= 5"
            ),
            uiEvent = { }
        )
    }
}
