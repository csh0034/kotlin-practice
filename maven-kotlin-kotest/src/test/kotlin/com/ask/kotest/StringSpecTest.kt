package com.ask.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

internal class StringSpecTest : StringSpec({
    "텍스트 길이 체크" {
        "hello".length shouldBe 5
    }
    "텍스트 prefix 체크" {
        "world" should startWith("wor")
    }
})
