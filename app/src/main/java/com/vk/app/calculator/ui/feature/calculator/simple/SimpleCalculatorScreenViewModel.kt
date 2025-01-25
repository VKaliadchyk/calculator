package com.vk.app.calculator.ui.feature.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.SimpleCalculator
import com.vk.app.calculator.logic.calculator.simple.model.CalculationResult
import com.vk.app.calculator.ui.base.BaseViewModel
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.SimpleCalculatorScreenReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent.FinalizeCalculation
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent.OutputUpdate
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent.EqualsKeyPress
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent.InputKeyPress
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
            is InputKeyPress -> {
                val output = calculator.processInput(uiEvent.key)
                reducer.handleEvent(OutputUpdate(output))
            }

            is EqualsKeyPress -> {
                val output = calculator.finalizeCalculation()
                if (output.result is CalculationResult.Success) {
                    reducer.handleEvent(FinalizeCalculation(output))
                }
            }
        }
    }
}
