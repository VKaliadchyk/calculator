package com.vk.app.calculator.ui.feature.calculator.simple

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vk.app.calculator.R
import com.vk.app.calculator.ui.components.KeyboardButton
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun SimpleCalculatorScreen(modifier: Modifier = Modifier) {
    Column {
        Box(modifier = Modifier.weight(0.75f)) {
            //TODO input\output screen placeholder
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
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
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
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
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
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
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
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
                KeyboardButton(
                    vectorId = R.drawable.test_inner_24,
                    size = buttonSize,
                    onClick = { /* TODO implement */ }
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SimpleCalculatorScreenPreview() {
    CalculatorTheme {
        SimpleCalculatorScreen()
    }
}
