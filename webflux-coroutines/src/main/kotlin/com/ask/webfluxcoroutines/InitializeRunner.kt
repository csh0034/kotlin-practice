package com.ask.webfluxcoroutines

import com.ask.webfluxcoroutines.entity.Endpoint
import com.ask.webfluxcoroutines.repository.EndpointRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class InitializeRunner(
  private val endpointRepository: EndpointRepository
) : ApplicationRunner {

  override fun run(args: ApplicationArguments?) {
    endpointRepository.save(Endpoint(serial = "aaa", name = "ASk"))
  }

}
