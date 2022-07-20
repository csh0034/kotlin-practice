package com.ask.webfluxcoroutines.service

import com.ask.webfluxcoroutines.entity.Endpoint
import com.ask.webfluxcoroutines.repository.EndpointRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EndpointService(
  private val endpointRepository: EndpointRepository
) {

  private val log = LoggerFactory.getLogger(javaClass)

  suspend fun getEndpointBySerial(serial: String): Endpoint? {
    log.info("getEndpointBySerial: $serial")
    return withContext(Dispatchers.IO) {
      endpointRepository.findBySerial(serial)
    }
  }

  suspend fun getTimestampWithSleep(delay: Long): Long {
    log.info("invoke... delay: $delay")
    delay(delay)
    return System.currentTimeMillis()
  }

}
