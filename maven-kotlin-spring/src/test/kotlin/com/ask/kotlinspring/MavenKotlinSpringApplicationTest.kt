package com.ask.kotlinspring

import com.ask.support.IntegrationTest
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import org.springframework.context.ApplicationContext
import org.springframework.transaction.annotation.Transactional

@IntegrationTest
@Transactional
internal class MavenKotlinSpringApplicationTest(
  private val applicationContext: ApplicationContext
) : ShouldSpec({
  extensions(SpringExtension)
  should("Spring Context Load") {
    applicationContext shouldNotBe null
  }
})
