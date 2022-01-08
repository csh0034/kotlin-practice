package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findByLoginId(loginId: String): User?
}
