package com.vk.app.calculator.logic.calculator.simple.model

import com.vk.app.calculator.common.EMPTY_STRING

data class Output(
    val input: String,
    val result: String
) {

    companion object {
        val defaultValue = Output(
            input = EMPTY_STRING,
            result = EMPTY_STRING
        )
    }
}
