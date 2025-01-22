package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import com.vk.app.calculator.ui.base.UiEvent

sealed class SimpleCalculatorScreenUiEvent : UiEvent {

    class KeypadKeyPress(val key: SimpleCalculatorKey) : SimpleCalculatorScreenUiEvent()
}
