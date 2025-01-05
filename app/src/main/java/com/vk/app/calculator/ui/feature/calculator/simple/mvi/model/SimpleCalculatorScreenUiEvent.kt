package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

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

    data object KeyClearPress : SimpleCalculatorScreenUiEvent()

    data object KeyDelPress : SimpleCalculatorScreenUiEvent()

    data object KeyPercentPress : SimpleCalculatorScreenUiEvent()

    data object KeyDividePress : SimpleCalculatorScreenUiEvent()

    data object KeyMultiplyPress : SimpleCalculatorScreenUiEvent()

    data object KeySubtractPress : SimpleCalculatorScreenUiEvent()

    data object KeyAddPress : SimpleCalculatorScreenUiEvent()

    data object KeyEqualsPress : SimpleCalculatorScreenUiEvent()

    data object KeyDotPress : SimpleCalculatorScreenUiEvent()
}
