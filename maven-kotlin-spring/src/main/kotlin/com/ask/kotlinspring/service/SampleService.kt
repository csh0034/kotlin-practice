package com.ask.kotlinspring.service

import org.springframework.stereotype.Service

@Service
class SampleService {

    fun getUnixTimestamp() = System.currentTimeMillis()
}
