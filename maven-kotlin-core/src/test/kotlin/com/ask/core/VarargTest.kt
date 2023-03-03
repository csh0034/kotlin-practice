package com.ask.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VarargTest {

  @Test
  fun `vararg test`() {
    assertThat(varargToList()).hasSize(0)
    assertThat(varargToList("a")).hasSize(1)
    assertThat(varargToList("a", "b")).hasSize(2)
  }

}

private fun varargToList(vararg args: String) = args.toList()
