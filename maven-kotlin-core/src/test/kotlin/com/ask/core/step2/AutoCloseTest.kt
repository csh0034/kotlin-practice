package com.ask.core.step2

import org.junit.jupiter.api.Test
import java.io.File

class AutoCloseTest {

    @Test
    fun `auto close`() {
        val stream = javaClass.classLoader.getResourceAsStream("myFile.txt")

        // 메모리에 한번에 올려놓고 처리한다.
        stream.use {
            it?.bufferedReader()
                ?.lineSequence()
                ?.forEach(::println)
        }
    }

    @Test
    fun `file read`() {
        // 파일을 한줄씩 처리
        val file = javaClass.classLoader.getResource("myFile.txt")?.file ?: ""

        // 방법 1
        File(file).forEachLine { println(it) }

        // 방법 2
        File(file).useLines { it.forEach(::println) }
    }
}
