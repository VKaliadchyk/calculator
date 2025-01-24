package com.vk.app.calculator.ui.feature.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.SimpleCalculator
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import com.vk.app.calculator.ui.base.BaseViewModel
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.SimpleCalculatorScreenReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent.*
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent.KeyPress
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SimpleCalculatorScreenViewModel @Inject constructor(
    override val reducer: SimpleCalculatorScreenReducer,
    private val calculator: SimpleCalculator
) : BaseViewModel<SimpleCalculatorScreenUiState, SimpleCalculatorScreenUiEvent>() {

    override val uiState: StateFlow<SimpleCalculatorScreenUiState>
        get() = reducer.uiState

    override fun handleUiEvent(uiEvent: SimpleCalculatorScreenUiEvent) {
        when (uiEvent) {
            is KeyPress -> {
                val calculationResult = calculator.processInput(uiEvent.key)
                val reducerEvent = if (uiEvent.key == SimpleCalculatorKey.Equals && calculationResult.result.isNotEmpty()) {
                        FinalizeCalculation(calculationResult)
                    } else {
                        OutputUpdate(calculationResult)
                    }
                reducer.handleEvent(reducerEvent)
            }
        }
    }
}
