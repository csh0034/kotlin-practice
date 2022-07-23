package com.ask.webfluxcoroutines.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
class SecurityConfig {

  @Bean
  fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    return http.csrf { it.disable() }
      .formLogin(withDefaults())
      .authorizeExchange {
        it.pathMatchers("/security", "/endpoints/**").hasAnyRole("USER")
          .anyExchange().permitAll()
      }
      .build()
  }

}
