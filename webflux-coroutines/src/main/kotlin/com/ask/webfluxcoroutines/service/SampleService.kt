package com.ask.webfluxcoroutines.service

import com.ask.webfluxcoroutines.aspect.CoroutineCaching
import com.ask.webfluxcoroutines.entity.Endpoint
import com.ask.webfluxcoroutines.repository.EndpointRepository
import com.ask.webfluxcoroutines.util.logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class SampleService(
  private val endpointRepository: EndpointRepository
) {

  private val log = logger()

  @CoroutineCaching("endpoint...")
//  @CoroutineLogging
  suspend fun getEndpoint(): Endpoint? {
    return withContext(Dispatchers.IO) {
      log.info("delay 1...")
      delay(1000)

      log.info("delay 2...")
      delay(1000)

      log.info("findBySerial...")
      endpointRepository.findBySerial("aaa")
    }
  }

}
