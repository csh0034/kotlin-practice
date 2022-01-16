package com.ask.kotlinspring

import com.ask.kotlinspring.domain.Company
import com.ask.kotlinspring.domain.User
import com.ask.kotlinspring.domain.User.Role
import com.ask.kotlinspring.repository.CompanyRepository
import com.ask.kotlinspring.repository.UserRepository
import org.hibernate.Hibernate
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Component
class AppRunner(
    private val companyRepository: CompanyRepository,
    private val userRepository: UserRepository,
    private val entityManager: EntityManager
) : ApplicationRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Transactional
    override fun run(args: ApplicationArguments) {
        log.info("AppRunner invoke")

        val company = Company(name = "company!")
        companyRepository.save(company)

        userRepository.saveAll(
            listOf(
                User(
                    name = "admin",
                    loginId = "user01",
                    password = "{bcrypt}\$2a\$10\$NGkfJGB16oYP6oNiECAvaOQU2Rf5uJJjRyuDREAjgNYql41csyGLm",
                    role = Role.ROLE_ADMIN,
                    company = company
                ),
                User(
                    name = "user",
                    loginId = "user02",
                    password = "{bcrypt}\$2a\$10\$NGkfJGB16oYP6oNiECAvaOQU2Rf5uJJjRyuDREAjgNYql41csyGLm",
                    role = Role.ROLE_USER,
                    company = company
                )
            )
        )

        entityManager.flush()
        entityManager.clear()

        val user = userRepository.findAll()[0]

        log.info("user : $user")
        log.info("user.company isInitialized : ${Hibernate.isInitialized(user.company)}")
    }
}