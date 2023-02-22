package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.Company
import com.ask.support.RepositoryTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@RepositoryTest
class CompanyRepositoryTest(
  private val companyRepository: CompanyRepository
) {

  @Test
  fun save() {
    val company = Company(name = "companyName")
    companyRepository.saveAndFlush(company)
    assertThat(company.id).isNotNull
  }
}
