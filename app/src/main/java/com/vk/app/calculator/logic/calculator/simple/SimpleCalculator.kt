package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

interface SimpleCalculator {

    var inputString: String

    fun processInput(input: SimpleCalculatorKey): Output
}
