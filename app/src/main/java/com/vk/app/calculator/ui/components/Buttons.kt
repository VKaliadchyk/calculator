package com.vk.app.calculator.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.vk.app.calculator.R
import com.vk.app.calculator.ui.theme.CalculatorTheme

@Composable
fun KeyboardButton(
    modifier: Modifier = Modifier,
    vectorId: Int,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    Image(
        modifier = modifier.clickable(onClick = onClick),
        imageVector = ImageVector.vectorResource(vectorId),
        contentDescription = contentDescription
    )
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
