package com.ask.core

import org.junit.jupiter.api.Test

internal class CollectionsTest {

  @Test
  fun chunked() {
    (1..50).chunked(8).forEach { println(it) }
  }

  @Test
  fun shuffled() {
    val shuffled = (1..9).shuffled()
    shuffled.subList(0, 3).toList().forEach { println(it) }
    shuffled.subList(0, 3).toList().forEach { println(it) }
    shuffled.subList(0, 3).toList().forEach { println(it) }
  }

  @Test
  fun lotto() {
    val numbers = (1..45)

    repeat(10) {
      println(numbers.shuffled().take(6).sorted())
    }
  }

}
