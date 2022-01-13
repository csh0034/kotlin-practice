package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EqualityIdentityTest {

    @Test
    fun equality() {
        val user1 = User("ask", 30)
        val user2 = User("ask", 30)

        // 동등성, equals
        assertThat(user1 == user2).isTrue
    }

    @Test
    fun identity() {
        val user1 = User("ask", 30)
        val user2 = User("ask", 30)

        // 동일성
        assertThat(user1 === user2).isFalse
    }

    // data class 는 equals, hasCode 가 자동 재정의 된다.
    data class User(val name: String, val age: Int)
}
