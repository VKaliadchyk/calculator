package com.vk.app.calculator.logic.calculator.simple.builder

import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey

interface ExpressionBuilder {

    var expressionString: String

    fun appendKey(key: SimpleCalculatorKey): String
}
