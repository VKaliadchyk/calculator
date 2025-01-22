package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCore
import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCoreImpl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows


import org.junit.Test

class CalculatorCoreImplTests {

    private val core: CalculatorCore = CalculatorCoreImpl()

    @Test
    fun `2+2 should result 4`() {
        //GIVEN:
        val expression = "2+2"

        //WHEN:
        val result = core.evaluate(expression)

        //THEN:
        assertEquals(4.0, result, 0.0)
    }

    @Test
    fun `evaluate should correctly calculate complex expression`() {
        //GIVEN:
        val expression = "6+3*2/3-3"

        //WHEN:
        val result = core.evaluate(expression)

        //THEN:
        assertEquals(5.0, result, 0.0)
    }

    @Test
    fun `test`() {
        //GIVEN:
        val expression = "2+2="

        //WHEN:
        //THEN:
        assertThrows(IllegalArgumentException::class.java, { core.evaluate(expression) })
    }
}
