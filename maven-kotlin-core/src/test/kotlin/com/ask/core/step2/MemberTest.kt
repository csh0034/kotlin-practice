package com.ask.core.step2

import org.junit.jupiter.api.Test
import java.time.Instant

internal class MemberTest {

    @Test
    fun create() {
        val member = Member(29, "ASk", Instant.now())
        println(member)
    }
}