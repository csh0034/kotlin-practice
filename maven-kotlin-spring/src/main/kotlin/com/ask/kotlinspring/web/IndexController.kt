package com.ask.kotlinspring.web

import com.ask.kotlinspring.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController(
    private val sampleService: SampleService
) {

    @GetMapping
    fun index() = "index"

    @GetMapping("/time")
    fun time() = sampleService.getUnixTimestamp().toString()
}