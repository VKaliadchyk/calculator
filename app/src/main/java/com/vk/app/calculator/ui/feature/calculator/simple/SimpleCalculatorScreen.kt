package com.vk.app.calculator.ui.feature.calculator.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.app.calculator.R
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Add
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Clear
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Del
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Divide
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Dot
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Eight
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Equals
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Five
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Four
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Multiply
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Nine
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.One
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Percent
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Seven
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Six
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Subtract
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Three
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Two
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Zero
import com.vk.app.calculator.ui.components.HorizontalSpacer
import com.vk.app.calculator.ui.components.KeyboardButton
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent.KeyPress
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
            Text(text = uiState.equation, fontSize = 36.sp)
            HorizontalSpacer(height = 12.dp)
            Text(text = uiState.result, fontSize = 28.sp, color = Color.Black.copy(alpha = 0.60f))
        }
        HorizontalDivider()
        HorizontalSpacer(height = 8.dp)

        val buttonPadding = 40.dp
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
                    onClick = { uiEvent(KeyPress(Clear)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_del,
                    contentDescription = "DEL key",
                    onClick = { uiEvent(KeyPress(Del)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_percent,
                    contentDescription = "% key",
                    onClick = { uiEvent(KeyPress(Percent)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_divide,
                    contentDescription = "/ key",
                    onClick = { uiEvent(KeyPress(Divide)) }
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
                    onClick = { uiEvent(KeyPress(Seven)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_eight,
                    contentDescription = "8 key",
                    onClick = { uiEvent(KeyPress(Eight)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_nine,
                    contentDescription = "9 key",
                    onClick = { uiEvent(KeyPress(Nine)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_multiply,
                    contentDescription = "* key",
                    onClick = { uiEvent(KeyPress(Multiply)) }
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
                    onClick = { uiEvent(KeyPress(Four)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_five,
                    contentDescription = "5 key",
                    onClick = { uiEvent(KeyPress(Five)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_six,
                    contentDescription = "6 key",
                    onClick = { uiEvent(KeyPress(Six)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_subtract,
                    contentDescription = "- key",
                    onClick = { uiEvent(KeyPress(Subtract)) }
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
                    onClick = { uiEvent(KeyPress(One)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_two,
                    contentDescription = "2 key",
                    onClick = { uiEvent(KeyPress(Two)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_three,
                    contentDescription = "3 key",
                    onClick = { uiEvent(KeyPress(Three)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_add,
                    contentDescription = "+ key",
                    onClick = { uiEvent(KeyPress(Add)) }
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
                    onClick = { uiEvent(KeyPress(Zero)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_dot,
                    contentDescription = ". key",
                    onClick = { uiEvent(KeyPress(Dot)) }
                )
                KeyboardButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    vectorId = R.drawable.keypad_equals,
                    contentDescription = "= key",
                    onClick = { uiEvent(KeyPress(Equals)) }
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
                result = "= 5"
            ),
            uiEvent = { }
        )
    }
}
