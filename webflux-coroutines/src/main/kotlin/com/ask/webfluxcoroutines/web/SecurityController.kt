package com.ask.webfluxcoroutines.web

import com.ask.webfluxcoroutines.config.getAuthentication
import com.ask.webfluxcoroutines.util.logger
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class SecurityController {

  private val log = logger()

  @GetMapping("/security")
  suspend fun security(@AuthenticationPrincipal user: User, principal: Principal): Any {
    log.info("user: $user")
    log.info("token: ${principal as UsernamePasswordAuthenticationToken}")
    return getAuthentication()
  }

}
