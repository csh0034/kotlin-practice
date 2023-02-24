package com.ask.kotlinspring.web

import com.ask.support.IntegrationTest
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.transaction.annotation.Transactional

@IntegrationTest
@Transactional
internal class UserControllerTest(
  private val mockMvc: MockMvc
) : BehaviorSpec({
  extension(SpringExtension)

  Given("cname company 의 user 조회의 경우") {
    val companyName = "cname"

    When("/users 호출시") {
      val result = mockMvc.get("/users") {
        param("companyName", companyName)
      }

      Then("해당 company 의 포함된 user 를 리턴한다.") {
        result.andExpect {
          status { isOk() }
          jsonPath("$.length()") { value(3) }
          jsonPath("$[0].id") { value("user21") }
          jsonPath("$[1].id") { value("user22") }
          jsonPath("$[2].id") { value("user23") }
        }.andDo {
          print()
        }
      }
    }
  }
})

@IntegrationTest
@Transactional
class UserController2Test(
  private val mockMvc: MockMvc,
) {

  @Test
  fun findUsers() {
    // given
    val companyName = "cname"

    // when
    val result = mockMvc.get("/users") {
      param("companyName", companyName)
    }

    // then
    result.andExpect {
      status { isOk() }
      jsonPath("$.length()") { value(3) }
      jsonPath("$[0].id") { value("user21") }
      jsonPath("$[1].id") { value("user22") }
      jsonPath("$[2].id") { value("user23") }
    }.andDo {
      print()
    }
  }
}
