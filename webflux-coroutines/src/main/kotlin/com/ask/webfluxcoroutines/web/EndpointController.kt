package com.ask.webfluxcoroutines.web

import com.ask.webfluxcoroutines.service.EndpointService
import com.ask.webfluxcoroutines.util.logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.http.ResponseEntity
import org.springframework.util.StopWatch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EndpointController(
  private val endpointService: EndpointService
) {

  private val log = logger()

  @GetMapping("/endpoints/by/{serial}")
  suspend fun getEndpointBySerial(@PathVariable("serial") serial: String): ResponseEntity<ResponseVO> {
    val stopWatch = StopWatch()
    stopWatch.start()

    val result = endpointService.getEndpointBySerial(serial)

    val responseVO = coroutineScope {

      val resultA = async { endpointService.getTimestampWithSleep(1000) }
      val resultB = async { endpointService.getTimestampWithSleep(2000) }

      ResponseVO(
        code = 200,
        timestamp1 = resultA.await(),
        timestamp2 = resultB.await(),
        data = result!!
      )
    }

    stopWatch.stop()
    log.info("time: ${stopWatch.totalTimeMillis}")

    return ResponseEntity.ok(responseVO)
  }

  @GetMapping("/endpoints/{serial}/update")
  suspend fun update(@PathVariable("serial") serial: String): String {
    endpointService.update(serial)
    return "update..."
  }


  data class ResponseVO(val code: Int, val timestamp1: Long, val timestamp2: Long, val data: Any)

}
