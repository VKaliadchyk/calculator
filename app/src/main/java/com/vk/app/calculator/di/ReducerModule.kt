package com.vk.app.calculator.di

import com.vk.app.calculator.ui.base.BaseReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.SimpleCalculatorScreenReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenReducerEvent
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ReducerModule {

    @Provides
    fun provideSimpleCalculatorScreenReducer(): BaseReducer<SimpleCalculatorScreenUiState, out SimpleCalculatorScreenReducerEvent> {
        return SimpleCalculatorScreenReducer(SimpleCalculatorScreenUiState.defaultValue)
    }
}
