package com.ask.kotlinspring.service

import com.ask.kotlinspring.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByLoginId(username)?.let {
            User.withUsername(it.name)
                .password(it.password)
                .authorities(it.role.name)
                .build()
        } ?: throw UsernameNotFoundException("$username Not Found")
    }
}
