package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.Company
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CompanyRepositoryTest(
    @Autowired private val companyRepository: CompanyRepository
) {

    @Test
    fun save() {
        val company = Company(name = "companyName")
        companyRepository.saveAndFlush(company)
        assertThat(company.id).isNotNull
    }
}
