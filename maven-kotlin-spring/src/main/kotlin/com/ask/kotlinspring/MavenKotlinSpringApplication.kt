package com.ask.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MavenKotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<MavenKotlinSpringApplication>(*args)
}
