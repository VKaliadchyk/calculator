package com.vk.app.calculator.ui.feature.calculator.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.app.calculator.R
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ADD
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.CLEAR
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.BACKSPACE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.DIVIDE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.DECIMAL
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.EIGHT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.FIVE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.FOUR
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.MULTIPLY
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.NINE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ONE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.PERCENT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SEVEN
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SIX
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SUBTRACT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.THREE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.TWO
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ZERO
import com.vk.app.calculator.ui.components.HorizontalSpacer
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
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(0.75f)
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.End
            ) {
                items(items = uiState.history) { item ->
                    Text(text = item)
                }
            }
            HorizontalSpacer(height = 28.dp)
            Text(text = uiState.equation, fontSize = 36.sp)
            HorizontalSpacer(height = 12.dp)
            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                val resultFontSize = 28.sp
                val resultFontColor = Color.Black.copy(alpha = 0.60f)
                if (uiState.result.isNotEmpty()) {
                    Text(text = "=", fontSize = resultFontSize, color = resultFontColor)
                }
                Text(text = uiState.result, fontSize = resultFontSize, color = resultFontColor)
            }
        }
        HorizontalDivider()
        HorizontalSpacer(height = 8.dp)

        val buttonPadding = 48.dp
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonPadding),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_ac,
                    contentDescription = "AC key",
                    onClick = { uiEvent(InputKeyPress(CLEAR)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_del,
                    contentDescription = "DEL key",
                    onClick = { uiEvent(InputKeyPress(BACKSPACE)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_percent,
                    contentDescription = "% key",
                    onClick = { uiEvent(InputKeyPress(PERCENT)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_divide,
                    contentDescription = "/ key",
                    onClick = { uiEvent(InputKeyPress(DIVIDE)) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonPadding),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_seven,
                    contentDescription = "7 key",
                    onClick = { uiEvent(InputKeyPress(SEVEN)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_eight,
                    contentDescription = "8 key",
                    onClick = { uiEvent(InputKeyPress(EIGHT)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_nine,
                    contentDescription = "9 key",
                    onClick = { uiEvent(InputKeyPress(NINE)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_multiply,
                    contentDescription = "* key",
                    onClick = { uiEvent(InputKeyPress(MULTIPLY)) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonPadding),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_four,
                    contentDescription = "4 key",
                    onClick = { uiEvent(InputKeyPress(FOUR)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_five,
                    contentDescription = "5 key",
                    onClick = { uiEvent(InputKeyPress(FIVE)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_six,
                    contentDescription = "6 key",
                    onClick = { uiEvent(InputKeyPress(SIX)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_subtract,
                    contentDescription = "- key",
                    onClick = { uiEvent(InputKeyPress(SUBTRACT)) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonPadding),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_one,
                    contentDescription = "1 key",
                    onClick = { uiEvent(InputKeyPress(ONE)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_two,
                    contentDescription = "2 key",
                    onClick = { uiEvent(InputKeyPress(TWO)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_three,
                    contentDescription = "3 key",
                    onClick = { uiEvent(InputKeyPress(THREE)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_add,
                    contentDescription = "+ key",
                    onClick = { uiEvent(InputKeyPress(ADD)) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(buttonPadding),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.test_inner_24,
                    contentDescription = "Unused key",
                    onClick = {  /*TODO Implement*/  }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_zero,
                    contentDescription = "0 key",
                    onClick = { uiEvent(InputKeyPress(ZERO)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_dot,
                    contentDescription = ". key",
                    onClick = { uiEvent(InputKeyPress(DECIMAL)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_equals,
                    contentDescription = "= key",
                    onClick = { uiEvent(EqualsKeyPress) }
                )
            }
        }
        HorizontalSpacer(height = 32.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleCalculatorScreenPreview() {
    CalculatorTheme {
        SimpleCalculatorScreen(
            uiState = SimpleCalculatorScreenUiState.defaultValue.copy(
                equation = "0 + 5",
                result = "5",
                history = listOf(
                    "2+2=4",
                    "7+8=15",
                    "1*20=20",
                    "4*16=64"
                )
            ),
            uiEvent = { }
        )
    }
}
