package com.vk.app.calculator.logic.calculator.simple.model

import com.vk.app.calculator.common.EMPTY_STRING

sealed class CalculationResult {

    open val value: String = EMPTY_STRING

    class Success(override val value: String) : CalculationResult()

    data object Failure : CalculationResult()
}
