package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.Company
import com.ask.support.RepositoryTest
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.extensions.spring.SpringTestExtension
import io.kotest.extensions.spring.SpringTestLifecycleMode
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.string.shouldNotBeEmpty

/**
 * SpringTestLifecycleMode.Root 로 설정하지 않을 경우 첫번째 expect 처리후 rollback 처리된다.
 */
@RepositoryTest
class CompanyRepositoryTest(
  private val companyRepository: CompanyRepository
) : ExpectSpec({
  extensions(SpringTestExtension(SpringTestLifecycleMode.Root))


  context("회사 저장후 조회") {
    val companyName = "sample-company"

    expect("저장후 id가 존재해야 한다") {
      val company = Company(name = companyName)
      companyRepository.save(company)
      company.id.shouldNotBeEmpty()
    }

    expect("저장된 name 으로 조회할수 있다") {
      val company = companyRepository.findByName(companyName)
      company.shouldNotBeNull()
    }
  }
})
