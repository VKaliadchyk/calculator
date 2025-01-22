package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.common.EMPTY_STRING
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilder
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilderImpl
import com.vk.app.calculator.logic.calculator.simple.model.SimpleCalculatorKey
import org.junit.Assert.assertEquals

import org.junit.Test


class ExpressionBuilderImplTests {

    private val builder: ExpressionBuilder = ExpressionBuilderImpl()



    @Test
    fun `clear should make expressionString empty`() {
        //GIVEN:
        builder.expressionString = "12.32+65"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Clear)

        //THEN:
        val result = builder.expressionString
        assertEquals(EMPTY_STRING, result)
    }

    @Test
    fun `del should remove symbols from the end`() {
        //GIVEN:
        builder.expressionString = "12.32+65"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)
        builder.appendKey(SimpleCalculatorKey.Del)

        //THEN:
        val result = builder.expressionString
        assertEquals("1", result)
    }

    @Test
    fun `should not append multiple dots in a single number`() {
        //GIVEN:
        builder.expressionString = "12"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.One)
        builder.appendKey(SimpleCalculatorKey.Two)
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.Three)
        builder.appendKey(SimpleCalculatorKey.Four)

        //THEN:
        val result = builder.expressionString
        assertEquals("12.1234", result)
    }

    @Test
    fun `should not append multiple dots in a complex expression`() {
        //GIVEN:
        builder.expressionString = "2+4*1"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Zero)
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.One)
        builder.appendKey(SimpleCalculatorKey.Two)
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.Three)
        builder.appendKey(SimpleCalculatorKey.Four)

        //THEN:
        val result = builder.expressionString
        assertEquals("2+4*10.1234", result)
    }

    @Test
    fun `dot should be appended in complex expressions`() {
        //GIVEN:
        builder.expressionString = "2*3+7"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.One)
        builder.appendKey(SimpleCalculatorKey.Two)
        builder.appendKey(SimpleCalculatorKey.Three)

        //THEN:
        val result = builder.expressionString
        assertEquals("2*3+7.123", result)
    }

    @Test
    fun `dot should not be appended if last symbol is operator`() {
        //GIVEN:
        builder.expressionString = "1+"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Dot)

        //THEN:
        val result = builder.expressionString
        assertEquals("1+", result)
    }

    @Test
    fun `appending dot symbol on empty string result in 0 and dot string`() {
        //GIVEN:
        builder.expressionString = EMPTY_STRING

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Dot)

        //THEN:
        val result = builder.expressionString
        assertEquals("0.", result)
    }

    @Test
    fun `appending multiple dot symbols result in appending a single dot symbol`() {
        //GIVEN:
        builder.expressionString = "1"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.Dot)
        builder.appendKey(SimpleCalculatorKey.Dot)

        //THEN:
        val result = builder.expressionString
        assertEquals("1.", result)
    }

    @Test
    fun `appending operator with dot on the end should remove dot`() {
        //GIVEN:
        builder.expressionString = "4+2."

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Multiply)

        //THEN:
        val result = builder.expressionString
        assertEquals("4+2*", result)
    }

    @Test
    fun `appending multiple operators replaces last operator with the final one`() {
        //GIVEN:
        builder.expressionString = "1+"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Subtract)
        builder.appendKey(SimpleCalculatorKey.Add)
        builder.appendKey(SimpleCalculatorKey.Multiply)
        builder.appendKey(SimpleCalculatorKey.Divide)

        //THEN:
        val result = builder.expressionString
        assertEquals("1/", result)
    }

    @Test
    fun `double appending + should result single +`() {
        //GIVEN:
        builder.expressionString = "1"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Add)
        builder.appendKey(SimpleCalculatorKey.Add)

        //THEN:
        val result = builder.expressionString
        assertEquals("1+", result)
    }

    @Test
    fun `appending + key on empty input should return empty string`() {
        //GIVEN:
        builder.expressionString = EMPTY_STRING

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Add)

        //THEN:
        val result = builder.expressionString
        assertEquals("", result)
    }

    @Test
    fun `input 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 should result 1234567890 in input`() {
        //GIVEN:
        builder.expressionString = EMPTY_STRING

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.One)
        builder.appendKey(SimpleCalculatorKey.Two)
        builder.appendKey(SimpleCalculatorKey.Three)
        builder.appendKey(SimpleCalculatorKey.Four)
        builder.appendKey(SimpleCalculatorKey.Five)
        builder.appendKey(SimpleCalculatorKey.Six)
        builder.appendKey(SimpleCalculatorKey.Seven)
        builder.appendKey(SimpleCalculatorKey.Eight)
        builder.appendKey(SimpleCalculatorKey.Nine)
        builder.appendKey(SimpleCalculatorKey.Zero)

        //THEN:
        val result = builder.expressionString
        assertEquals("1234567890", result)
    }

    @Test
    fun `should not append multiple zeros to initial zero string`() {
        //GIVEN:
        builder.expressionString = "0"

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Zero)
        builder.appendKey(SimpleCalculatorKey.Zero)
        builder.appendKey(SimpleCalculatorKey.Zero)

        //THEN:
        val result = builder.expressionString
        assertEquals("0", result)
    }

    @Test
    fun `input 2, +, 3 should result 2+3 string`() {
        //GIVEN:
        builder.expressionString = EMPTY_STRING

        //WHEN:
        builder.appendKey(SimpleCalculatorKey.Two)
        builder.appendKey(SimpleCalculatorKey.Add)
        builder.appendKey(SimpleCalculatorKey.Three)

        //THEN:
        val result = builder.expressionString
        assertEquals("2+3", result)
    }
}
