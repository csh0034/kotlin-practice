package com.ask.kotlinspring.web

import com.ask.kotlinspring.service.SampleService
import com.ask.support.IntegrationTest
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

@IntegrationTest
@Transactional
internal class IndexControllerTest(
  private val mockMvc: MockMvc,
  @MockkBean private val sampleService: SampleService
) : BehaviorSpec({
  extension(SpringExtension)

  Given("IndexController") {
    When("/ 호출시") {
      Then("index 라는 문자열을 리턴한다.") {
        mockMvc.get("/") {
          accept(MediaType.TEXT_PLAIN)
        }.andExpect {
          status { isOk() }
          content { string("index") }
        }.andDo {
          print()
        }
      }
    }
  }

  Given("IndexController With MockkBean") {
    val currentTime = 1L
    every { (sampleService.getUnixTimestamp()) } returns currentTime

    When("/time 호출시") {
      Then("현재 시간을 리턴한다.") {
        mockMvc.get("/time") {
          accept(MediaType.TEXT_PLAIN)
        }.andExpect {
          status { isOk() }
          content { string(currentTime.toString()) }
        }.andDo {
          print()
        }
      }
    }
  }
})

@IntegrationTest
@Transactional
internal class IndexController2Test(
  private val mockMvc: MockMvc,
  @MockkBean private val sampleService: SampleService
) : AnnotationSpec() {
  override fun extensions() = listOf(SpringExtension)

  @io.kotest.core.spec.style.Test
  fun index() {
    // when
    val result = mockMvc.perform(get("/"))

    // then
    result.andDo(print())
      .andExpect(status().isOk)
      .andExpect(content().string("index"))
  }

  @Test
  fun `index with dsl`() {
    mockMvc.get("/") {
      accept(MediaType.TEXT_PLAIN)
    }.andExpect {
      status { isOk() }
      content { string("index") }
    }.andDo {
      print()
    }
  }

  @Test
  fun time() {
    every { (sampleService.getUnixTimestamp()) } returns 1

    mockMvc.get("/time") {
      accept(MediaType.TEXT_PLAIN)
    }.andExpect {
      status { isOk() }
      content { string("1") }
    }.andDo {
      print()
    }
  }
}

@IntegrationTest
@Transactional
internal class IndexController3Test(
  private val mockMvc: MockMvc,
  @MockkBean private val sampleService: SampleService
) {

  @Test
  fun index() {
    // when
    val result = mockMvc.perform(get("/"))

    // then
    result.andDo(print())
      .andExpect(status().isOk)
      .andExpect(content().string("index"))
  }

  @Test
  fun `index with dsl`() {
    mockMvc.get("/") {
      accept(MediaType.TEXT_PLAIN)
    }.andExpect {
      status { isOk() }
      content { string("index") }
    }.andDo {
      print()
    }
  }

  @Test
  fun time() {
    every { (sampleService.getUnixTimestamp()) } returns 1

    mockMvc.get("/time") {
      accept(MediaType.TEXT_PLAIN)
    }.andExpect {
      status { isOk() }
      content { string("1") }
    }.andDo {
      print()
    }
  }
}
