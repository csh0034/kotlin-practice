package com.ask.core.step2

import org.junit.jupiter.api.Test
import java.time.Instant

internal class OpenPersonTest {

    @Test
    fun create() {
        val openPerson = OpenPerson("ASk", Instant.now())

        // field access 처럼 보이지만 getter 호출임
        println("name : ${openPerson.name}")
        println("creatDt : ${openPerson.createDt}")
    }
}