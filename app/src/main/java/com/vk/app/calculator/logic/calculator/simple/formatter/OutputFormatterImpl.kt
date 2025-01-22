package com.vk.app.calculator.logic.calculator.simple.formatter

class OutputFormatterImpl : OutputFormatter {

    override fun formatOutput(output: Double): String {
        val hasFraction = output % 1 != 0.0

        return if (hasFraction) {
            "= $output"
        } else {
            "= ${output.toLong()}"
        }
    }
}
