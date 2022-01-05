package com.ask.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionKtTest {

    private val function = Function()

    @Test
    fun sum() {
        // given
        val a = 10
        val b = 20

        // when
        val sum = function.sum(a, b)

        // then
        assertThat(sum).isEqualTo(30)
    }

    @Test
    fun max() {
        // given
        val a = 10
        val b = 20

        // when
        val max = function.max(a, b)

        // then
        assertThat(max).isEqualTo(20)
    }

    @Test
    fun getLen() {
        // given
        val str: String? = null

        // when
        val len = function.getLen(str)

        // then
        assertThat(len).isEqualTo(0)
    }
}
