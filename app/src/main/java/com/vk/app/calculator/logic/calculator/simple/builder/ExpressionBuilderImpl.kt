package com.vk.app.calculator.logic.calculator.simple.builder

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ADD
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.CLEAR
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.BACKSPACE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.DIVIDE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.DECIMAL
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.EIGHT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.FIVE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.FOUR
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.MULTIPLY
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.NINE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ONE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.PERCENT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SEVEN
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SIX
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.SUBTRACT
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.THREE
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.TWO
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey.ZERO

class ExpressionBuilderImpl : ExpressionBuilder {

    override var expressionString: String = EMPTY_STRING

    override fun appendKey(key: SimpleCalculatorKey): String {
        when (key) {
            DECIMAL -> appendDot()
            BACKSPACE -> expressionString = expressionString.dropLast(1)
            CLEAR -> expressionString = EMPTY_STRING
            ONE -> expressionString += "1"
            TWO -> expressionString += "2"
            THREE -> expressionString += "3"
            FOUR -> expressionString += "4"
            FIVE -> expressionString += "5"
            SIX -> expressionString += "6"
            SEVEN -> expressionString += "7"
            EIGHT -> expressionString += "8"
            NINE -> expressionString += "9"
            ZERO -> {
                if (expressionString == "0") {
                    // do nothing
                } else {
                    expressionString += "0"
                }
            }
            ADD,
            SUBTRACT,
            MULTIPLY,
            DIVIDE,
            PERCENT -> appendOperator(key)
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
            ADD -> "+"
            DIVIDE -> "/"
            SUBTRACT -> "-"
            MULTIPLY -> "*"
            else -> throw NotImplementedError("Operation is not supported: $input")
        }
    }

    private fun Char.isOperator(): Boolean {
        return this == '+' || this == '/' || this == '-' || this == '*'
    }
}
