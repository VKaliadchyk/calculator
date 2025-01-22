package com.vk.app.calculator.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vk.app.calculator.R
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun KeyboardButton(
    modifier: Modifier = Modifier,
    vectorId: Int,
    size: Dp = 40.dp,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.clickable(onClick = onClick),
    ) {
        Image(
            modifier = Modifier.size(size),
            imageVector = ImageVector.vectorResource(vectorId),
            contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
fun KeyboardImageButtonPreview() {
    CalculatorTheme {
        Surface {
            KeyboardButton(vectorId = R.drawable.keypad_two, onClick = {})
        }
    }
}
