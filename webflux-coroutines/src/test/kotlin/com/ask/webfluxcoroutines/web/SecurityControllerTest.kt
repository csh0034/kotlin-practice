package com.ask.webfluxcoroutines.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithUserDetails
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
internal class SecurityControllerTest(
  @Autowired private val webTestClient: WebTestClient
) {

  @Test
  @WithUserDetails("user01")
  fun security() {
    webTestClient.get()
      .uri("/security")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk
      .expectBody()
      .jsonPath("$.name").isEqualTo("user01")
      .jsonPath("$.authenticated").isEqualTo("true")
      .jsonPath("$.principal.username").isEqualTo("user01")
      .jsonPath("$.authorities[0].authority").isEqualTo("ROLE_USER")
      .consumeWith(System.out::println);
  }

}
