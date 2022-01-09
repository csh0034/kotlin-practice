package com.ask.kotlinspring

import com.ask.kotlinspring.domain.User
import com.ask.kotlinspring.domain.User.*
import com.ask.kotlinspring.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner(
    private var userRepository: UserRepository
) : ApplicationRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun run(args: ApplicationArguments) {
        log.info("AppRunner invoke")

        userRepository.saveAll(
            listOf(
                User(
                    name = "admin",
                    loginId = "user01",
                    password = "{bcrypt}\$2a\$10\$NGkfJGB16oYP6oNiECAvaOQU2Rf5uJJjRyuDREAjgNYql41csyGLm",
                    role = Role.ROLE_ADMIN
                ),
                User(
                    name = "user",
                    loginId = "user02",
                    password = "{bcrypt}\$2a\$10\$NGkfJGB16oYP6oNiECAvaOQU2Rf5uJJjRyuDREAjgNYql41csyGLm",
                    role = Role.ROLE_USER
                )
            )
        )
    }
}