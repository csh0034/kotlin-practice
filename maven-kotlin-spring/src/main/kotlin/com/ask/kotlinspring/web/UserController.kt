package com.ask.kotlinspring.web

import com.ask.kotlinspring.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/users")
    fun findUsers(companyName: String) =
        userService.findAllByCompanyName(companyName)
}
