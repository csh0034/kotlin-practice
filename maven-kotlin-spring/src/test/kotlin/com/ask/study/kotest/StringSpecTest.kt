package com.ask.study.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.endWith
import io.kotest.matchers.string.startWith

internal class StringSpecTest : StringSpec({
  "텍스트 길이 체크" {
    "hello".length shouldBe 5
  }
  "텍스트 prefix 체크" {
    "world" should startWith("wor")
  }
  "텍스트 suffix 체크" {
    "world" should endWith("ld")
  }
  "두 숫자중 큰수 체크" {
    forAll(
      row(1, 5, 5),
      row(1, 0, 1),
      row(0, 0, 0)
    ) { a, b, max ->
      a.coerceAtLeast(b) shouldBe max
    }
  }
})
