package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class UtilitiesKtTest {

    @DisplayName("Top-level function 으로 유틸리티 함수 선언")
    @Test
    fun getLength() {
        val length = getLength("abc")
        assertThat(length).isEqualTo(3)
    }
}