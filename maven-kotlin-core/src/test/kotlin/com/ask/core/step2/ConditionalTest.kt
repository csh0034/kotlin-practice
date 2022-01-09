package com.ask.core.step2

import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class ConditionalTest {

    @Test
    fun `if`() {
        val a = Random.nextInt(10)
        val b = Random.nextInt(10)

        val condition = if (a > b)
            "a>b"
        else
            "a<b"

        println("a : $a")
        println("b : $b")
        println("condition : $condition")
    }

    @Test
    fun when1() {
        val random = Random.nextInt(5) + 1

        val result = when (random) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            else -> "Unknown..."
        }

        println("random : $random")
        println("result : $result")
    }

    @Test
    fun when2() {
        val random = Random.nextInt(5) + 1
        val randomBoolean = Random.nextBoolean()

        val result = when {
            randomBoolean -> "randomBoolean!!"
            random == 1 -> "one"
            random == 2 -> "two"
            random == 3 -> "three"
            random == 4 -> "four"
            random == 5 -> "test"
            else -> "Unknown..."
        }

        println("random : $random")
        println("result : $result")
    }
}
