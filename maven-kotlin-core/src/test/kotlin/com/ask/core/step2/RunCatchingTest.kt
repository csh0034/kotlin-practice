package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RunCatchingTest {

    @Test
    fun `runCatching null`() {
        val name: String? = null

        runCatching {
            name ?: throw NullPointerException("name is null")
        }.onSuccess {
            println("name is $it")
        }.onFailure { e ->
            println(e.message)
        }.also {
            println("isFailure : ${it.isFailure}")
        }
    }

    @Test
    fun `runCatching not null`() {
        val name: String? = "ASk"

        val resultName = runCatching {
            name ?: throw NullPointerException("name is null")
        }.onSuccess {
            println("name is $it")
        }.onFailure { e ->
            println(e.message)
        }.also {
            println("isFailure : ${it.isFailure}")
        }.getOrDefault("default !!")

        println("resultName : $resultName")

        assertThat(resultName).isEqualTo(name)
    }
}
