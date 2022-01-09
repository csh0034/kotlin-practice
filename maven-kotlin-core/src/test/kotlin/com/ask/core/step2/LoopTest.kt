package com.ask.core.step2

import org.junit.jupiter.api.Test

internal class LoopTest {

    @Test
    fun `index loop1`() {
        // 중위연산자(infix) 사용
        for (i in 0 until 10 step 2) {
            println("i : $i")
        }
    }

    @Test
    fun `index loop2`() {
        val range = 0 until 10
        for (i in range) {
            println("i : $i")
        }
    }

    @Test
    fun `index loop3`() {
        // 중위연산자 미사용
        for (i in 0.until(10).step(2)) println(i)
    }

    @Test
    fun `index loop4`() {
        for (i in 0..10) {
            println("i : $i")
        }
    }
}
