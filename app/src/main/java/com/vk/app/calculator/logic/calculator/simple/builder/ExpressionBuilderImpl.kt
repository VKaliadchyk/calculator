package com.vk.app.calculator.logic.calculator.simple.builder

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Add
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Clear
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Del
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Divide
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Dot
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Eight
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Five
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Four
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Multiply
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Nine
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.One
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Percent
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Seven
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Six
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Subtract
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Three
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Two
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.Zero

class ExpressionBuilderImpl : ExpressionBuilder {

    override var expressionString: String = EMPTY_STRING

    override fun appendKey(key: SimpleCalculatorKey): String {
        when (key) {
            Dot -> appendDot()
            Del -> expressionString = expressionString.dropLast(1)
            Clear -> expressionString = EMPTY_STRING
            One -> expressionString += "1"
            Two -> expressionString += "2"
            Three -> expressionString += "3"
            Four -> expressionString += "4"
            Five -> expressionString += "5"
            Six -> expressionString += "6"
            Seven -> expressionString += "7"
            Eight -> expressionString += "8"
            Nine -> expressionString += "9"
            Zero -> {
                if (expressionString == "0") {
                    // do nothing
                } else {
                    expressionString += "0"
                }
            }

            Add,
            Subtract,
            Multiply,
            Divide,
            Percent -> appendOperator(key)
        }

        return expressionString
    }

    private fun appendDot() {
        if (expressionString.isEmpty()) expressionString = "0."
        if (expressionString.last().isOperator()) return
        if (expressionString.last() == '.') return
        if (isFractionalNumber()) return

        expressionString += "."
    }

    private fun isFractionalNumber(): Boolean {
        if (expressionString.isEmpty()) return false
        if (expressionString.last().isOperator()) return false

        val expressionStringChars = expressionString.toCharArray()

        for (i in expressionStringChars.size - 1 downTo 0) {
            if (expressionStringChars[i].isOperator()) break
            if (expressionStringChars[i] == '.') return true
        }

        return false
    }

    private fun appendOperator(input: SimpleCalculatorKey) {
        if (expressionString.isEmpty()) return

        val lastSymbol = expressionString.last()
        if (lastSymbol.isOperator() || lastSymbol == '.') {
            expressionString = expressionString.dropLast(1)
        }

        expressionString += when (input) {
            Add -> "+"
            Divide -> "/"
            Subtract -> "-"
            Multiply -> "*"
            else -> throw NotImplementedError("Operation is not supported: $input")
        }
    }

    private fun Char.isOperator(): Boolean {
        return this == '+' || this == '/' || this == '-' || this == '*'
    }
}
