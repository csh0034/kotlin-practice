package com.ask.core.step3

import org.junit.jupiter.api.Test

class FunctionReferenceTest {

    @Test
    fun `function reference`() {
        val multiplyBy1: (Int) -> Int = { n -> double(n) }
        val multiplyBy2: (Int) -> Int = { double(it) }
        val multiplyBy3: (Int) -> Int = ::double
        val multiplyBy4 = ::double

        println(multiplyBy1(2))
        println(multiplyBy2(3))
        println(multiplyBy3(4))
        println(multiplyBy4(5))
    }

    private fun double(n: Int) = n * 2
}
