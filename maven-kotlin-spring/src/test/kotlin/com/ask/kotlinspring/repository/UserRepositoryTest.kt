package com.ask.kotlinspring.repository

import com.ask.support.RepositoryTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import org.assertj.core.api.Assertions.assertThat

@RepositoryTest
class UserRepositoryTest(
  private val userRepository: UserRepository
) : StringSpec({
  extension(SpringExtension)

  "count" {
    assertThat(userRepository.count()).isEqualTo(3)
  }

  "findByLoginId" {
    val user = userRepository.findByLoginId("sample")
    assertThat(user).isNull()
  }

  "findAllByCompanyName" {
    val users = userRepository.findAllByCompanyName("cname")
    assertThat(users).hasSize(3)
  }
})
