package com.ask.webfluxcoroutines.service

import com.ask.webfluxcoroutines.aspect.CoroutineLogging
import com.ask.webfluxcoroutines.util.logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class SampleService {

  private val log = logger()

  @CoroutineLogging
  suspend fun getTimestamp(): Long {
    val timestamp = System.currentTimeMillis()

    withContext(Dispatchers.IO) {
      log.info("before delay")
      delay(3000)
      log.info("after delay")
    }

    return timestamp
  }

}
