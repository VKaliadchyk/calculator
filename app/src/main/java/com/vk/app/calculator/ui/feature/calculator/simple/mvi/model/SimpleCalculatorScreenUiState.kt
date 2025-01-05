package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.ui.base.UiState

data class SimpleCalculatorScreenUiState(val output: String) : UiState {

    companion object {
        val defaultValue = SimpleCalculatorScreenUiState(
            output = EMPTY_STRING
        )
    }
}
