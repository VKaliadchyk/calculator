package com.vk.app.calculator.ui.feature.calculator.simple

import com.vk.app.calculator.ui.base.BaseReducer
import com.vk.app.calculator.ui.base.BaseViewModel
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SimpleCalculatorScreenViewModel @Inject constructor(
    override val reducer: BaseReducer<SimpleCalculatorScreenUiState, out SimpleCalculatorScreenReducerEvent>
) : BaseViewModel<SimpleCalculatorScreenUiState, SimpleCalculatorScreenUiEvent>() {

    override val uiState: StateFlow<SimpleCalculatorScreenUiState>
        get() = reducer.uiState

    override fun handleUiEvent(uiEvent: SimpleCalculatorScreenUiEvent) {
        TODO("Not yet implemented")
    }
}
