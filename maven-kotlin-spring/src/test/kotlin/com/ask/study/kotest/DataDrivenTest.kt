package com.ask.study.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class DataDrivenTest : FunSpec({

  context("Pythagorean triple") {
    withData(
      PythagTriple(3, 4, 5),
      PythagTriple(6, 8, 10),
      PythagTriple(8, 15, 17),
      PythagTriple(7, 24, 25)
    ) { (a, b, c) ->
      isPythagTriple(a, b, c) shouldBe true
    }
  }

  context("add") {
    withData(
      nameFn = { "a=${it.a}, b=${it.b}, c=${it.c}" },
      row(1, 2, 3),
      row(2, 3, 5)
    ) { (a, b, c) ->
      a + b shouldBe c
    }
  }

})

fun isPythagTriple(a: Int, b: Int, c: Int): Boolean = a * a + b * b == c * c

data class PythagTriple(val a: Int, val b: Int, val c: Int)
