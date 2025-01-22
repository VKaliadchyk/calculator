package com.vk.app.calculator.di

import com.vk.app.calculator.ui.feature.calculator.simple.mvi.SimpleCalculatorScreenReducer
import com.vk.app.calculator.ui.feature.calculator.simple.mvi.model.SimpleCalculatorScreenUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ReducerModule {

    @Provides
    fun provideSimpleCalculatorScreenReducer(): SimpleCalculatorScreenReducer {
        return SimpleCalculatorScreenReducer(SimpleCalculatorScreenUiState.defaultValue)
    }
}
