package com.ask.webfluxcoroutines.repository;

import com.ask.webfluxcoroutines.entity.Endpoint
import org.springframework.data.jpa.repository.JpaRepository

interface EndpointRepository : JpaRepository<Endpoint, String> {

  fun findBySerial(serial: String): Endpoint?

}
