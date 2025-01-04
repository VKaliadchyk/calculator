package com.vk.app.calculator.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<S : UiState, E : UiEvent> : ViewModel() {

    protected abstract val reducer: BaseReducer<S, out ReducerEvent>

    abstract val uiState: StateFlow<S>

    abstract fun handleUiEvent(uiEvent: E)
}
