package com.vk.app.calculator.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalSpacer(modifier: Modifier = Modifier, height: Dp = 0.dp) {
    Spacer(modifier = modifier.fillMaxWidth().height(height))
}
