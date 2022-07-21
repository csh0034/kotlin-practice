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

  /**
   * @Transactional 이 동작하지않아 변경감지도 동작안함
   */
//  @Transactional
  suspend fun update(serial: String) {
    log.info("update... ${Thread.currentThread().name}")

    withContext(Dispatchers.IO) {
      log.info("update... in Dispatchers.IO ${Thread.currentThread().name}")

      val endpoint = endpointRepository.findBySerial(serial)!!
      endpoint.name = System.currentTimeMillis().toString()
    }
  }

}
