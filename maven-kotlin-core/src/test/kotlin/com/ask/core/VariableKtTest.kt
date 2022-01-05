package com.ask.core

import org.junit.jupiter.api.Test

internal class VariableKtTest {

    private val variable = Variable()

    @Test
    fun println() {
        println("Hello Kotlin")
    }

    @Test
    fun printlnVal() {
        val name: String = "ASk"
        println("Hello $name");
    }

    @Test
    fun printlnVal2() {
        val name = "ASk"    // 타입 추론
        println("Hello $name");
    }

    @Test
    fun nullable() {
        val nullName: String? = null
        println("nullName : $nullName")
    }

    @Test
    fun lazyVal() {
        val name: String by lazy(variable::getName)
        println("lazy...")
        println(name)
    }
}
