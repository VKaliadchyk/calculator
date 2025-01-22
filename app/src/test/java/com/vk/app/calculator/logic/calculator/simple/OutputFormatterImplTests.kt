package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatter
import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatterImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class OutputFormatterImplTests {

    private val formatter: OutputFormatter = OutputFormatterImpl()

    @Test
    fun `formatOutput() should return fractional number if input has fraction`() {
        //GIVEN:
        val rawOutput = 24.5

        //WHEN:
        val result = formatter.formatOutput(rawOutput)

        //THEN:
        assertEquals("24.5", result)
    }

    @Test
    fun `formatOutput() should return integer number if input has NOT fraction`() {
        //GIVEN:
        val rawOutput = 24.0

        //WHEN:
        val result = formatter.formatOutput(rawOutput)

        //THEN:
        assertEquals("24", result)
    }
}
