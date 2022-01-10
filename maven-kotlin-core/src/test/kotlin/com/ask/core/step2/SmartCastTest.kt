package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class SmartCastTest {

    @Test
    fun `smart cast if`() {
        val payload: Any = "string"

        val length = if (payload is String)
            payload.length
        else
            -1

        println("length = $length")
    }

    @Test
    fun `smart cast when`() {
        val payload: Any = "string"

        val result: Int = when (payload) {
            is String -> payload.length
            is Int -> payload
            else -> -1
        }

        println("payload = $payload")
        println("result = $result")
    }

    @Test
    fun `as operator`() {
        val payload: Any = "string"
        val result: String = payload as String

        println("result = $result")
    }

    @Test
    fun `unsafe cast, ClassCastException`() {
        val payload: Any = 1

        assertThatExceptionOfType(ClassCastException::class.java).isThrownBy {
            payload as String
        }
    }

    @Test
    fun `safe cast operator with elvis, false`() {
        val payload: Any = 1
        val value: String = payload as? String ?: "-1"

        println("payload $payload value $value")
    }

    @Test
    fun `safe(nullable) cast operator, true`() {
        val payload: Any = "string"
        val value: String = payload as? String ?: "-1"

        println("payload $payload value $value")
    }
}
