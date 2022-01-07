package com.ask.kotlinspring.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    companion object {
        const val LOGIN_SUCCESS_URL: String = "/index"
    }

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .requestMatchers(PathRequest.toH2Console())
    }
}