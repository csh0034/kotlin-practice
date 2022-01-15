package com.ask.kotlinspring.repository

import com.ask.kotlinspring.config.QuerydslConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(QuerydslConfig::class)
class UserRepositoryTest @Autowired constructor(
    private val userRepository: UserRepository
) {

    @Test
    fun count() {
        assertThat(userRepository.count()).isEqualTo(3)
    }

    @Test
    fun findByLoginId() {
        val user = userRepository.findByLoginId("sample")
        assertThat(user).isNull()
    }

    @Test
    fun findAllByCompanyName() {
        val users = userRepository.findAllByCompanyName("cname")
        assertThat(users).hasSize(3)

        println(users)
    }
}
