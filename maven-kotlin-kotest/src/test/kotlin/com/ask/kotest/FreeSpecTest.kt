package com.ask.kotest

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

internal class FreeSpecTest : FreeSpec() {

    override fun beforeSpec(spec: Spec) {
        println("beforeSpec")
    }

    override fun beforeContainer(testCase: TestCase) {
        println("beforeContainer")
    }

    override fun beforeTest(testCase: TestCase) {
        println("beforeTest")
    }

    override fun beforeEach(testCase: TestCase) {
        println("beforeEach")
    }

    override fun beforeAny(testCase: TestCase) {
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
