package com.vk.app.calculator.ui.feature.calculator.simple.mvi

import com.vk.app.calculator.ui.base.BaseReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent.*
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState

class SimpleCalculatorScreenReducer(initialVal: SimpleCalculatorScreenUiState) :
    BaseReducer<SimpleCalculatorScreenUiState, SimpleCalculatorScreenReducerEvent>(initialVal) {

    override fun reduce(
        oldState: SimpleCalculatorScreenUiState,
        event: SimpleCalculatorScreenReducerEvent
    ) {
        val newState = when (event) {
            is OutputUpdate -> {
                oldState.copy(
                    equation = event.output.input,
                    result = event.output.result
                )
            }
            is FinalizeCalculation -> {
                val historyEntry = "${oldState.equation}=${oldState.result}"
                val history = oldState.history.toMutableList()
                if (history.size >= HISTORY_ENTRY_LIMIT) history.removeAt(0)
                history.add(historyEntry)
                oldState.copy(
                    equation = event.output.input,
                    result = event.output.result,
                    history = history
                )
            }
        }

        setState(newState)
    }

    companion object {
        private const val HISTORY_ENTRY_LIMIT = 3
    }
}
