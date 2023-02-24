package com.ask.study.kotest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class BehaviorSpecTest : BehaviorSpec({
  val calculator = Calculator()


  Given("calculator") {
    val a = 1
    val b = 2
    When("1과 2를 더하면") {
      val result = calculator.add(a, b)
      Then("3이 반환된다") {
        result shouldBe 3
      }
    }

    When("입력값이 null 이거나 빈 값인 경우") {
      Then("IllegalArgumentException 예외를 던진다") {
        shouldThrow<IllegalArgumentException> {
          calculator.add(null as Int?, null as Int?)
        }
      }
    }
  }
})

class Calculator {
  fun add(a: Int?, b: Int?): Int {
    requireNotNull(a) { "a is null" }
    requireNotNull(b) { "b is null" }
    return a + b
  }
}
