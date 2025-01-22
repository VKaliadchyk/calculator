package com.vk.app.calculator.logic.calculator.simple

import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidator
import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidatorImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class ExpressionValidatorImplTests {

    private val validator: ExpressionValidator = ExpressionValidatorImpl()

    @Test
    fun `isValid() should return true on finished expression`() {
        //GIVEN:
        val validExpression = "2+2"

        //WHEN:
        val result = validator.isValid(validExpression)

        //THEN:
        assertEquals(result, true)
    }

    @Test
    fun `isValid() should return false when expression ends with operator`() {
        //GIVEN:
        val validExpression = "235+3211+"

        //WHEN:
        val result = validator.isValid(validExpression)

        //THEN:
        assertEquals(result, false)
    }

    @Test
    fun `isValid() should return false if expression doesn't have operators`() {
        //GIVEN:
        val validExpression = "123456"

        //WHEN:
        val result = validator.isValid(validExpression)

        //THEN:
        assertEquals(result, false)
    }
}
