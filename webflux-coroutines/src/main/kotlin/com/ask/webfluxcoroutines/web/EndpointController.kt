package com.ask.webfluxcoroutines.web

import com.ask.webfluxcoroutines.service.EndpointService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EndpointController(
  private val endpointService: EndpointService
) {

  @GetMapping("/endpoints/by/{serial}")
  suspend fun getEndpointBySerial(@PathVariable("serial") serial: String): ResponseEntity<Any> {
    val result = endpointService.getEndpointBySerial(serial)
    return if (result != null) {
      ResponseEntity(result, HttpStatus.OK)
    } else {
      ResponseEntity("not found", HttpStatus.NOT_FOUND)
    }
  }

}
