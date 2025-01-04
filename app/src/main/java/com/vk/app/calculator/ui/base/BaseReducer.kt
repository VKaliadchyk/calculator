package com.vk.app.calculator.ui.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseReducer<S: UiState, E: ReducerEvent>(initialVal: S) {

    private val _uiState: MutableStateFlow<S> = MutableStateFlow(initialVal)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    fun handleEvent(event: E) {
        reduce(_uiState.value, event)
    }

    protected fun setState(newState: S) {
        _uiState.update { newState }
    }

    protected abstract fun reduce(oldState: S, event: E)
}
