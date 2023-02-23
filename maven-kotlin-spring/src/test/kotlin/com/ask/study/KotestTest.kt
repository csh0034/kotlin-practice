package com.ask.study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class KotestTest : StringSpec({
  "mcokk 와 kotest 를 함께 사용할 수 있다" {
    val calculator = mockk<Calculator>()
    every { calculator.add(any(), any()) } answers { -1 }

    calculator.add(1, 1) shouldBe -1

    verify { calculator.add(1, 1) }
  }
})

class Calculator {
  fun add(a: Int, b: Int) = a + b
}
