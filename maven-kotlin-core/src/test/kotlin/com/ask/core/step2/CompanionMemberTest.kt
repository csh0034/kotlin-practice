package com.ask.core.step2

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CompanionMemberTest {

    @DisplayName("companion object 를 통해 정적 메서드 처럼 구현")
    @Test
    fun returnXml() {
        val keyword = "xml!!!"
        val returnXml = CompanionMember.returnXml(keyword)

        // 가능하지만 비추천
        // CompanionMember.Companion.returnXml(keyword)

        assertThat(keyword).isEqualTo(returnXml)
    }

    @DisplayName("미구현 처리")
    @Test
    fun create() {
        assertThatExceptionOfType(NotImplementedError::class.java).isThrownBy {
            CompanionMember.create("test")
        }
    }
}