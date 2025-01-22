package com.vk.app.calculator.di

import com.vk.app.calculator.logic.calculator.simple.SimpleCalculator
import com.vk.app.calculator.logic.calculator.simple.SimpleCalculatorImpl
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilder
import com.vk.app.calculator.logic.calculator.simple.builder.ExpressionBuilderImpl
import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCore
import com.vk.app.calculator.logic.calculator.simple.core.CalculatorCoreImpl
import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidator
import com.vk.app.calculator.logic.calculator.simple.core.validator.ExpressionValidatorImpl
import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatter
import com.vk.app.calculator.logic.calculator.simple.formatter.OutputFormatterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SimpleCalculatorModule {

    @Provides
    fun provideSimpleCalculator(
        calculatorCore: CalculatorCore,
        expressionBuilder: ExpressionBuilder,
        expressionValidator: ExpressionValidator,
        outputFormatter: OutputFormatter
    ): SimpleCalculator {
        return SimpleCalculatorImpl(
            calculatorCore,
            expressionBuilder,
            expressionValidator,
            outputFormatter
        )
    }

    @Provides
    fun provideExpressionBuilder(): ExpressionBuilder {
        return ExpressionBuilderImpl()
    }

    @Provides
    fun provideCalculatorCore(): CalculatorCore {
        return CalculatorCoreImpl()
    }

    @Provides
    fun provideExpressionValidator(): ExpressionValidator {
        return ExpressionValidatorImpl()
    }

    @Provides
    fun provideOutputFormatter(): OutputFormatter {
        return OutputFormatterImpl()
    }
}
