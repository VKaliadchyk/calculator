package com.vk.app.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vk.app.calculator.R
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun Test(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxWidth()) {
            KeyboardButton(
                modifier = Modifier.weight(1f),
                vectorId = R.drawable.keypad_ac,
                contentDescription = "AC key",
                onClick = {  }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                vectorId = R.drawable.keypad_del,
                contentDescription = "DEL key",
                onClick = {  }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                vectorId = R.drawable.keypad_percent,
                contentDescription = "% key",
                onClick = {  }
            )
            KeyboardButton(
                modifier = Modifier.weight(1f),
                vectorId = R.drawable.keypad_divide,
                contentDescription = "/ key",
                onClick = {  }
            )
        }
    }
}

@Composable
@Preview
fun TestPreview() {
    CalculatorTheme {
        Surface {
            Test()
        }
    }
}
