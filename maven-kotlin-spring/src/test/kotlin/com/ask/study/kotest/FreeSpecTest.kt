package com.ask.study.kotest

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

internal class FreeSpecTest : FreeSpec() {

  override suspend fun beforeSpec(spec: Spec) {
    println("beforeSpec")
  }

  override suspend fun beforeContainer(testCase: TestCase) {
    println("beforeContainer")
  }

  override suspend fun beforeTest(testCase: TestCase) {
    println("beforeTest")
  }

  override suspend fun beforeEach(testCase: TestCase) {
    println("beforeEach")
  }

  override suspend fun beforeAny(testCase: TestCase) {
    println("beforeAny")
  }

  init {
    "ContainerScope" - {
      "TerminalScope 1" {
        "".length shouldBe 0
      }
      "TerminalScope 2" {
        "12345".length shouldBe 5
      }
    }
  }
}
