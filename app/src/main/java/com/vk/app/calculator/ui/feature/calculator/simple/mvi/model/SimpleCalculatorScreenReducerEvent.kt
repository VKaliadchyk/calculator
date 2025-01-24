package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.ui.base.ReducerEvent

sealed class SimpleCalculatorScreenReducerEvent : ReducerEvent {

    class OutputUpdate(val output: Output) : SimpleCalculatorScreenReducerEvent()

    class FinalizeCalculation(val output: Output) : SimpleCalculatorScreenReducerEvent()
}
