package com.vk.app.calculator.logic.calculator.simple.builder

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

class ExpressionBuilderImpl : ExpressionBuilder {

    override var expressionString: String = EMPTY_STRING

    override fun appendKey(key: SimpleCalculatorKey): String {
        when (key) {
            SimpleCalculatorKey.One -> expressionString += "1"
            SimpleCalculatorKey.Two -> expressionString += "2"
            SimpleCalculatorKey.Three -> expressionString += "3"
            SimpleCalculatorKey.Four -> expressionString += "4"
            SimpleCalculatorKey.Five -> expressionString += "5"
            SimpleCalculatorKey.Six -> expressionString += "6"
            SimpleCalculatorKey.Seven -> expressionString += "7"
            SimpleCalculatorKey.Eight -> expressionString += "8"
            SimpleCalculatorKey.Nine -> expressionString += "9"
            SimpleCalculatorKey.Zero -> {
                if (expressionString == "0") {
                    // do nothing
                } else {
                    expressionString += "0"
                }
            }
            SimpleCalculatorKey.Add,
            SimpleCalculatorKey.Subtract,
            SimpleCalculatorKey.Multiply,
            SimpleCalculatorKey.Divide,
            SimpleCalculatorKey.Percent -> appendOperationSign(key)
            SimpleCalculatorKey.Equals -> { /* do nothing */ }

            else -> {
                TODO("Not yet implemented")
            }
        }

        return expressionString
    }

    private fun appendOperationSign(input: SimpleCalculatorKey) {
        if (expressionString.isEmpty()) return

        val lastSymbol = expressionString.last()
        if (lastSymbol.isOperator()) expressionString = expressionString.dropLast(1)

        expressionString += when (input) {
            SimpleCalculatorKey.Add -> "+"
            SimpleCalculatorKey.Divide -> "/"
            SimpleCalculatorKey.Subtract -> "-"
            SimpleCalculatorKey.Multiply -> "*"
            else -> throw NotImplementedError("Operation is not supported: $input")
        }
    }

    private fun Char.isOperator(): Boolean {
        return this == '+' || this == '/' || this == '-' || this == '*'
    }
}
