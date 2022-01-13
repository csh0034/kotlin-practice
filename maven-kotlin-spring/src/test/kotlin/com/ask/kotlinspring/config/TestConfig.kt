package com.ask.kotlinspring.config

import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.TestConfiguration

@TestConfiguration
@EnableConfigurationProperties(H2ConsoleProperties::class)
class TestConfig {
}
