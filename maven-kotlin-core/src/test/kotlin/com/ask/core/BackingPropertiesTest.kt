package com.ask.core

import org.junit.jupiter.api.Test

class BackingPropertiesTest {

    @Test
    fun `backing properties`() {
        val backingProperties = BackingProperties(Sample("ASk"))

        println("before backingProperties.sample = ${backingProperties.sample}")

//        컴파일 에러
//        backingProperties.sample = Sample("Test")

        backingProperties.updateSample(Sample("Update!"))

        println("after backingProperties.sample = ${backingProperties.sample}")
    }
}
