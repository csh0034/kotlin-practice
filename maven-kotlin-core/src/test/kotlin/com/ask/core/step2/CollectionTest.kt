package com.ask.core.step2

import org.junit.jupiter.api.Test

internal class CollectionTest {

    @Test
    fun `immutable collection`() {
        // 리스트 연산은 가능하다.
        val list1 = listOf(1, 2, 3)
        val list2 = list1 + 4
        val list3 = list1 + list2

        println(list1)
        println(list2)
        println(list3)
    }

    @Test
    fun `mutable collection`() {
        val list1 = mutableListOf(1, 2, 3)
        val list2: Boolean = list1.add(4)
        val list3: Boolean = list1.addAll(list1)

        println(list1)
        println(list2)
        println(list3)
    }
}
