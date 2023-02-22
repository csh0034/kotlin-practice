package com.ask.kotlinspring.repository

import com.ask.support.RepositoryTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@RepositoryTest
class UserRepositoryTest(
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
