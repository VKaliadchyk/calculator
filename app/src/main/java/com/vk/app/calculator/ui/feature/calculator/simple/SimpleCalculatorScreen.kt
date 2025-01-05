package com.vk.app.calculator.ui.feature.calculator.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vk.app.calculator.R
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
    Column(modifier = modifier) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(0.75f)) {
            //TODO input\output screen placeholder
            Text(uiState.output)
        }
        HorizontalDivider()
        Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.weight(1f)) {
            val buttonSize: Dp = 74.dp
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //TODO change vectors for all buttons
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "AC key",
                    onClick = { uiEvent(KeyClearPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "DEL key",
                    onClick = { uiEvent(KeyDelPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "% key",
                    onClick = { uiEvent(KeyPercentPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "/ key",
                    onClick = { uiEvent(KeyDividePress) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //TODO change vectors for all buttons
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "7 key",
                    onClick = { uiEvent(KeySevenPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "8 key",
                    onClick = { uiEvent(KeyEightPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "9 key",
                    onClick = { uiEvent(KeyNinePress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "* key",
                    onClick = { uiEvent(KeyMultiplyPress) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //TODO change vectors for all buttons
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "4 key",
                    onClick = { uiEvent(KeyFourPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "5 key",
                    onClick = { uiEvent(KeyFivePress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "6 key",
                    onClick = { uiEvent(KeySixPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "- key",
                    onClick = { uiEvent(KeySubtractPress) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //TODO change vectors for all buttons
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "1 key",
                    onClick = { uiEvent(KeyOnePress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "2 key",
                    onClick = { uiEvent(KeyTwoPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "3 key",
                    onClick = { uiEvent(KeyThreePress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "+ key",
                    onClick = { uiEvent(KeyAddPress) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                //TODO change vectors for all buttons
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "Unused key",
                    onClick = { /* TODO Implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "0 key",
                    onClick = { uiEvent(KeyZeroPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = ". key",
                    onClick = { uiEvent(KeyDotPress) }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    contentDescription = "= key",
                    onClick = { uiEvent(KeyEqualsPress) }
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
            uiState = SimpleCalculatorScreenUiState.defaultValue,
            uiEvent = { }
        )
    }
}
