package com.ask.webfluxcoroutines.service

import com.ask.webfluxcoroutines.entity.Endpoint
import com.ask.webfluxcoroutines.repository.EndpointRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EndpointService(
  private val endpointRepository: EndpointRepository
) {

  private val log = LoggerFactory.getLogger(javaClass)

  suspend fun getEndpointBySerial(serial: String): Endpoint? {
    log.info("getEndpointBySerial: $serial")
    return endpointRepository.findBySerial(serial)
  }

}
