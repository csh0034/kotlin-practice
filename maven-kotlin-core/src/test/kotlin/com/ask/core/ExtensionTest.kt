package com.ask.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class ExtensionTest {

  @Test
  fun `extension function test`() {
    val users = listOf(User("1", "ASk"), User("2", "Bsk"))

    assertThat(users.summary).hasSize(2)
    assertThat(users.summary()).hasSize(2)
  }

}

private data class User(val id: String, val name: String)

// Extension property
private val List<User>.summary
  get() = associate { it.id to it.name }

// Extension function
private fun List<User>.summary() = associate { it.id to it.name }
