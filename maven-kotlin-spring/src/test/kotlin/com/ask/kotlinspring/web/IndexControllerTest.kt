package com.ask.kotlinspring.web

import com.ask.kotlinspring.service.SampleService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(IndexController::class)
class IndexControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var sampleService: SampleService

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
        given(sampleService.getUnixTimestamp()).willReturn(1L)

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
