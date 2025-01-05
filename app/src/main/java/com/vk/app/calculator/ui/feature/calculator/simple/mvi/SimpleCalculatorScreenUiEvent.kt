package com.vk.app.calculator.ui.feature.calculator.simple.mvi

import com.vk.app.calculator.ui.base.UiEvent

sealed class SimpleCalculatorScreenUiEvent : UiEvent {

    data object KeyZeroPress : SimpleCalculatorScreenUiEvent()

    data object KeyOnePress : SimpleCalculatorScreenUiEvent()

    data object KeyTwoPress : SimpleCalculatorScreenUiEvent()

    data object KeyThreePress : SimpleCalculatorScreenUiEvent()

    data object KeyFourPress : SimpleCalculatorScreenUiEvent()

    data object KeyFivePress : SimpleCalculatorScreenUiEvent()

    data object KeySixPress : SimpleCalculatorScreenUiEvent()

    data object KeySevenPress : SimpleCalculatorScreenUiEvent()

    data object KeyEightPress : SimpleCalculatorScreenUiEvent()

    data object KeyNinePress : SimpleCalculatorScreenUiEvent()
}
