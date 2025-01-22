package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilder
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilderImpl
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import org.junit.Assert.assertEquals

import org.junit.Test


class ExpressionBuilderImplTests {

    private val expressionBuilder: ExpressionBuilder = ExpressionBuilderImpl()

    @Test
    fun `appending multiple operators replaces last operator with the final one`() {
        //GIVEN:
        expressionBuilder.expressionString = "1+"

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.Subtract)
        expressionBuilder.appendKey(SimpleCalculatorKey.Add)
        expressionBuilder.appendKey(SimpleCalculatorKey.Multiply)
        expressionBuilder.appendKey(SimpleCalculatorKey.Divide)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("1/", result)
    }

    @Test
    fun `double appending + should result single +`() {
        //GIVEN:
        expressionBuilder.expressionString = "1"

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.Add)
        expressionBuilder.appendKey(SimpleCalculatorKey.Add)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("1+", result)
    }

    @Test
    fun `appending + key on empty input should return empty string`() {
        //GIVEN:
        expressionBuilder.expressionString = EMPTY_STRING

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.Add)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("", result)
    }

    @Test
    fun `input 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 should result 1234567890 in input`() {
        //GIVEN:
        expressionBuilder.expressionString = EMPTY_STRING

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.One)
        expressionBuilder.appendKey(SimpleCalculatorKey.Two)
        expressionBuilder.appendKey(SimpleCalculatorKey.Three)
        expressionBuilder.appendKey(SimpleCalculatorKey.Four)
        expressionBuilder.appendKey(SimpleCalculatorKey.Five)
        expressionBuilder.appendKey(SimpleCalculatorKey.Six)
        expressionBuilder.appendKey(SimpleCalculatorKey.Seven)
        expressionBuilder.appendKey(SimpleCalculatorKey.Eight)
        expressionBuilder.appendKey(SimpleCalculatorKey.Nine)
        expressionBuilder.appendKey(SimpleCalculatorKey.Zero)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("1234567890", result)
    }

    @Test
    fun `should not append multiple zeros to initial zero string`() {
        //GIVEN:
        expressionBuilder.expressionString = "0"

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.Zero)
        expressionBuilder.appendKey(SimpleCalculatorKey.Zero)
        expressionBuilder.appendKey(SimpleCalculatorKey.Zero)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("0", result)
    }

    @Test
    fun `input 2, +, 3 should result 2+3 string`() {
        //GIVEN:
        expressionBuilder.expressionString = EMPTY_STRING

        //WHEN:
        expressionBuilder.appendKey(SimpleCalculatorKey.Two)
        expressionBuilder.appendKey(SimpleCalculatorKey.Add)
        expressionBuilder.appendKey(SimpleCalculatorKey.Three)

        //THEN:
        val result = expressionBuilder.expressionString
        assertEquals("2+3", result)
    }
}
