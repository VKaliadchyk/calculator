package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilder
import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCore
import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidator
import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatter
import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

class SimpleCalculatorImpl(
    private val calculatorCore: CalculatorCore,
    private val expressionBuilder: ExpressionBuilder,
    private val validator: ExpressionValidator,
    private val formatter: OutputFormatter
) : SimpleCalculator {

    override var inputString: String = EMPTY_STRING

    override fun processInput(input: SimpleCalculatorKey): Output {
        inputString = expressionBuilder.appendKey(input)

        if (validator.isValid(inputString)) {
            val expressionResult = calculatorCore.evaluate(inputString)
            val formattedResult = formatter.formatOutput(expressionResult)
            return Output(
                input = inputString,
                result = formattedResult
            )
        } else {
            return Output(
                input = inputString,
                result = EMPTY_STRING
            )
        }

    }
}
