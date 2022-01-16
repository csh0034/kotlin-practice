package com.ask.kotlinspring.web

import com.ask.kotlinspring.config.TestConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig::class)
class UserControllerTest @Autowired constructor(
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
