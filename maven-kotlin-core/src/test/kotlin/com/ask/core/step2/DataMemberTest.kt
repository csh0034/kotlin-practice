package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DataMemberTest {

    @DisplayName("class 앞에 data 추가시에 equals, hashCode 자동 재정의")
    @Test
    fun create() {
        val dataMember1 = DataMember("ASk")
        val dataMember2 = DataMember("ASk")
        val dataMember3 = dataMember2.copy()

        println(dataMember1)

        assertThat(dataMember1).isEqualTo(dataMember2).isEqualTo(dataMember3)
    }

    @DisplayName("data 구조분해 선언")
    @Test
    fun destructing() {
        val dataMember = DataMember("ASk")
        val (name, age) = dataMember

        println("name : $name")
        println("age : $age")

        println("dataMember.component1() : ${dataMember.component1()}")
        println("dataMember.component2() : ${dataMember.component2()}")
    }

    @DisplayName("Map 구조분해 선언")
    @Test
    fun map() {
        val map = mapOf("key1" to "value1", "key2" to "value2")

        for ((key, value) in map) {
            println("$key : $value")
        }
    }
}
