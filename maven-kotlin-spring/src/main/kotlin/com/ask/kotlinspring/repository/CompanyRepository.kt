package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, String> {
}
