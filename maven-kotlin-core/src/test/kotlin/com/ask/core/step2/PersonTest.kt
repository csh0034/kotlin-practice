package com.ask.core.step2

import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    fun create() {
        val person1 = Person()
        val person2 = Person("ASk")

        println("person1 : $person1")
        println("person2 : $person2")
    }
}