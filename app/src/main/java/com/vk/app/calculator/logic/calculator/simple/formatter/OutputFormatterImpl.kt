package com.vk.app.calculator.logic.calculator.simple.formatter

import java.util.Locale

class OutputFormatterImpl : OutputFormatter {

    override fun formatOutput(output: Double): String {
        val hasFraction = output % 1 != 0.0

        return if (hasFraction) {
            if (isRepeatingDecimal(output)) {
                String.format(Locale.US,"%.10f", output)
            } else {
                output.toString()
            }
        } else {
            output.toLong().toString()
        }
    }

    private fun isRepeatingDecimal(value: Double): Boolean {
        val decimalPart = value.toString().split(".").getOrNull(1) ?: return false
        val length = decimalPart.length

        for (size in 1..length / 2) {
            val firstChunk = decimalPart.substring(0, size)
            var isRepeating = true

            for (i in size until length step size) {
                val secondChunk = decimalPart.substring(i, (i + size).coerceAtMost(length))
                if (firstChunk != secondChunk) {
                    isRepeating = false
                    break
                }
            }

            if (isRepeating) return true
        }

        return false
    }
}
