package com.vk.app.calculator.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.vk.app.calculator.R
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun Test(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxWidth()) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.keypad_ac),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.keypad_del),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.keypad_percent),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.keypad_divide),
                contentDescription = null
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
