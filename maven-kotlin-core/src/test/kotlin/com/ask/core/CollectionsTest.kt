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

  @Test
  fun sortedWith() {
    val list = listOf(
      SortResponse(false, 0, "a"),
      SortResponse(true, 1, "b"),
      SortResponse(false, 2, "c"),
      SortResponse(true, 4, "d"),
    )

    val sortedList = list.sortedWith(
      compareBy({ !it.enabled }, { it.enabledTimestamp })
    )

    sortedList.forEach { println(it) }
  }

  data class SortResponse(
    val enabled: Boolean,
    val enabledTimestamp: Long,
    val title: String,
  )

}
