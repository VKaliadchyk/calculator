package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilder
import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCore
import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidator
import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatter
import com.vk.app.calculator.logic.calculator.simple.model.CalculationResult
import com.vk.app.calculator.logic.calculator.simple.model.Output
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

class SimpleCalculatorImpl(
    private val calculatorCore: CalculatorCore,
    private val expressionBuilder: ExpressionBuilder,
    private val validator: ExpressionValidator,
    private val formatter: OutputFormatter
) : SimpleCalculator {


    override fun processInput(input: SimpleCalculatorKey): Output {
        val expression = expressionBuilder.appendKey(input)

        return if (validator.isValid(expression)) {
            val rawResult = calculatorCore.evaluate(expression)
            val formattedResult = formatter.formatOutput(rawResult)
            Output(
                input = expressionBuilder.expressionString,
                result = CalculationResult.Success(formattedResult)
            )
        } else {
            Output(
                input = expressionBuilder.expressionString,
                result = CalculationResult.Failure
            )
        }
    }

    override fun finalizeCalculation(): Output {
        val expression = expressionBuilder.expressionString
        if (validator.isValid(expression)) {
            val rawResult = calculatorCore.evaluate(expression)
            val formattedResult = formatter.formatOutput(rawResult)
            expressionBuilder.expressionString = formattedResult

            return Output(
                input = expressionBuilder.expressionString,
                result = CalculationResult.Success(EMPTY_STRING)
            )
        } else {
            return Output(
                input = EMPTY_STRING,
                result = CalculationResult.Failure
            )
        }
    }
}
