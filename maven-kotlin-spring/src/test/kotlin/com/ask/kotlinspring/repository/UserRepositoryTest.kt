package com.ask.kotlinspring.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
    private val userRepository: UserRepository
) {

    @Test
    fun count() {
        assertThat(userRepository.count()).isZero
    }

    @Test
    fun findByLoginId() {
        val user = userRepository.findByLoginId("sample")
        assertThat(user).isNull()
    }
}
