package com.vk.app.calculator.ui.feature.calculator.simple.mvi

import com.vk.app.calculator.ui.base.BaseReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState

class SimpleCalculatorScreenReducer(initialVal: SimpleCalculatorScreenUiState) :
    BaseReducer<SimpleCalculatorScreenUiState, SimpleCalculatorScreenReducerEvent>(initialVal) {

    override fun reduce(
        oldState: SimpleCalculatorScreenUiState,
        event: SimpleCalculatorScreenReducerEvent
    ) {
        TODO("Not yet implemented")
    }
}
