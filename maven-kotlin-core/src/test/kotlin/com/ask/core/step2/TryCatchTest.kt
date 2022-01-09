package com.ask.core.step2

import org.junit.jupiter.api.Test

internal class TryCatchTest {

    @Test
    fun `try catch`() {
        val result = try {
            throw RuntimeException("exception!!!")
        } catch (e: Exception) {
            e.message
        } finally {
            println("call finally")
        }

        println("try catch result : $result")
    }
}
