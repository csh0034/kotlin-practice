package com.ask.core.step2

import org.junit.jupiter.api.Test

class StringInterpolationTest {

    @Test
    fun `string interpolation`() {
        val name = "ask"
        println("name : $name")
    }

    @Test
    fun `triple quote`() {
        val text = """first line.
                     |second line.
                     |third line."""

        println(text.trimMargin())
    }
}