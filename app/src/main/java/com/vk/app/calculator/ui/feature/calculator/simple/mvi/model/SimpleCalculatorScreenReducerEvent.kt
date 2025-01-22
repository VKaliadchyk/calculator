package com.vk.app.calculator.ui.feature.calculator.simple.mvi.model

import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.ui.base.ReducerEvent

sealed class SimpleCalculatorScreenReducerEvent : ReducerEvent {

    class UpdateOutput(val output: Output) : SimpleCalculatorScreenReducerEvent()
}
