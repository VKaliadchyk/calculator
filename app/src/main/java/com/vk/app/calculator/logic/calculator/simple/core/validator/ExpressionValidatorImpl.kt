package com.vk.app.calculator.logic.calculator.simple.core.validator

class ExpressionValidatorImpl : ExpressionValidator {

    override fun isValid(expression: String): Boolean {
        if (!expression.containsOperator()) return false

        return expression.last().isDigit()
    }

    private fun Char.isDigit(): Boolean {
        val digitsSet = setOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (digit in digitsSet) {
            if (this == digit) return true
        }

        return false
    }

    private fun String.containsOperator(): Boolean {
        val operatorsSet = setOf('+', '-', '*', '/')

        for (operator in operatorsSet) {
            if (this.contains(operator)) return true
        }

        return false
    }

}
