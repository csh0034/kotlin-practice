package com.ask.core.step2

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ObjectMemberFactoryTest {

    @DisplayName("object 키워드를 이용해 싱글톤 사용")
    @Test
    fun invoke() {
        val member1 = ObjectDataMemberFactory.create("ASk1")
        val member2 = ObjectDataMemberFactory.create("ASk2")

        println(member1)
        println(member2)

        println("length : ${ObjectDataMemberFactory.members.size}")
    }
}