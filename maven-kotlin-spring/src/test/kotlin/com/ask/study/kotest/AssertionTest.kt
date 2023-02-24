package com.ask.study.kotest

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.shouldForAtLeast
import io.kotest.inspectors.shouldForExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.*

internal class AssertionTest : FunSpec({
  context("Assertions") {
    test("io.kotest.matchers") {
      1 + 1 shouldBe 2
      1 + 1 shouldNotBe 3
    }
    test("io.kotest.matchers.string") {
      assertSoftly { // junit5 의 assertAll() 과 같은 기능
        "hello" shouldContain "el"
        "substring".shouldContain("sub").shouldBeLowerCase()
        "foo" shouldHaveLength 3
        "".shouldBeEmpty()
      }
    }
  }

  context("Inspectors") {
    val users = listOf("sam", "gareth", "timothy", "muhammad")

    test("io.kotest.inspectors") {
      users.shouldForExactly(4) {// forExactly
        it shouldHaveMinLength 3
      }

      users.shouldForAtLeast(1) { // forAtLeast
        it.shouldBeLowerCase()
      }
    }
  }
})
