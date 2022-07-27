package com.ask.webfluxcoroutines.web

import com.ask.webfluxcoroutines.service.SampleService
import com.ask.webfluxcoroutines.util.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
  private val sampleService: SampleService
) {

  private val log = logger()

  @GetMapping("/sample")
  suspend fun sample(): String {
    log.info("before suspend function")
    val endpoint = sampleService.getEndpoint()
    log.info("after suspend function, endpoint: $endpoint")

    return "invoke.."
  }

}
