package com.ask.kotest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class BehaviorSpecTest : BehaviorSpec({
    given("data") {
        val a = 1
        val b = 2
        `when`("1과 2를 더하면") {
            val result = a + b
            then("3이 반환된다") {
                result shouldBe 3
            }
        }

        val check: String? = null
        `when`("입력값이 null 이거나 빈 값인 경우") {
            then("IllegalArgumentException 예외를 던진다") {
                shouldThrow<IllegalStateException> {
                    checkNotNull(check)
                }
            }
        }
    }
})
