package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

interface SimpleCalculator {

    fun processInput(input: SimpleCalculatorKey): Output

    fun finalizeCalculation(): Output
}
