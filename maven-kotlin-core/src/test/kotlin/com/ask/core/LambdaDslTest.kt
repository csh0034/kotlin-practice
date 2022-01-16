package com.ask.core

import org.junit.jupiter.api.Test

class LambdaDslTest {

    @Test
    fun `invoke person1`() {
        person1 {
            it.name = "ASk"
            it.age = 20
        }.also {
            println("person = $it")
        }
    }

    @Test
    fun `invoke person2`() {
        person2 {
            name = "ASk"
            age = 20
        }.also {
            println("person = $it")
        }
    }

    @Test
    fun `invoke person3`() {
        person3 {
            name = "ASk"
            age = 20
            job {
                category = "ct1"
                position = "ps"
            }
        }.also {
            println("person = $it")
        }
    }
}