package com.vk.app.calculator.logic.calculator.simple.core

import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorCoreImpl : CalculatorCore {

    override fun evaluate(expression: String): Double {
        return ExpressionBuilder(expression).build().evaluate()
    }
}
