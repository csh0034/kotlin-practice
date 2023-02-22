package com.ask.kotlinspring.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

  companion object {
    private const val LOGIN_SUCCESS_URL: String = "/index"
  }

  override fun configure(web: WebSecurity) {
    web.ignoring()
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
      .antMatchers("/h2-console/**")
  }

  override fun configure(http: HttpSecurity) {
    http {
      headers {
        frameOptions {
          sameOrigin = true
        }
      }
      csrf {
        disable()
      }
      httpBasic {
        disable()
      }
      authorizeRequests {
        authorize("/admin/**", hasRole("ADMIN"))
        authorize(anyRequest, permitAll)
      }
      formLogin {
        defaultSuccessUrl(LOGIN_SUCCESS_URL, false)
      }
    }
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder =
    PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
