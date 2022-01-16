package com.ask.core

import org.junit.jupiter.api.Test

class LambdaDslTest {

    @Test
    fun `invoke person1`() {
        val person = person1 {
            it.name = "ASk"
            it.age = 20
        }
        println("person = $person")
    }

    @Test
    fun `invoke person2`() {
        val person = person2 {
            name = "ASk"
            age = 20
        }
        println("person = $person")
    }

    @Test
    fun `invoke person3`() {
        val person = person3 {
            name = "ASk"
            age = 20
            job {
                category = "ct1"
                position = "ps"
            }
        }
        println("person = $person")
    }
}