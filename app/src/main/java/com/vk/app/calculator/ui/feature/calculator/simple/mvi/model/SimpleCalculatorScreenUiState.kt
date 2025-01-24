package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.ui.base.UiState

data class SimpleCalculatorScreenUiState(
    val equation: String,
    val result: String,
    val history: List<String>
) : UiState {

    companion object {
        val defaultValue = SimpleCalculatorScreenUiState(
            equation = EMPTY_STRING,
            result = EMPTY_STRING,
            history = emptyList()
        )
    }
}
