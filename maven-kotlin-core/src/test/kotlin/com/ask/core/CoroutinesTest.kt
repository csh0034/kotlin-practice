package com.ask.core

import kotlinx.coroutines.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CoroutinesTest {

  @Test
  fun `runBlocking 테스트`() {
    println("before..")
    runBlocking {
      println("hello..")
      delay(200L)
      println("world..")
    }
    println("after..")
  }

  @Test
  fun `launch 테스트`() {
    println("before..")
    runBlocking {
      println("before launch..")
      launch {
        println("hello..")
        delay(200L)
        println("world..")
      }
      println("after launch..")
    }
    println("after..")
  }

  @Test
  fun `launch 테스트2`() {
    runBlocking {
      launch {
        println("default ${Thread.currentThread().name}")
      }
      launch(Dispatchers.IO) {
        println("io ${Thread.currentThread().name}")
      }
    }
  }

  @Test
  fun `async 테스트`() {

    runBlocking {
      val firstSum = async {
        println(Thread.currentThread().name)
        add(2, 2)
      }

      val secondSum = async {
        println(Thread.currentThread().name)
        add(3, 4)
      }

      println("awaiting concurrent sums...")
      val total = firstSum.await() + secondSum.await()
      println("total: $total")
    }

  }

  private suspend fun add(x: Int, y: Int): Int {
    delay(500L)
    return x + y;
  }

  @Test
  fun `coroutineScope 테스트`() {
    runBlocking {
      coroutineScope {
        (1..10).forEach {// repeat(10)
          launch(Dispatchers.IO) {
            delay(1000L - it * 10)
            println("${Thread.currentThread().name} $it")
          }
        }
      }
    }
  }

  @Nested
  inner class Suspend {

    @Test
    fun `각각 3초씩 6초가 소요됨`() {
      runBlocking {
        val answer1 = answer1()
        val answer2 = answer2()

        println("$answer1, $answer2")
      }
    }

    @Test
    fun `async await 사용으로 3초가 소요됨`() {
      runBlocking {
        val answer1 = async { answer1() }
        val answer2 = async { answer2() }

        println("${answer1.await()}, ${answer2.await()}")
      }
    }

    private suspend fun answer1(): String {
      println("answer1: ${Thread.currentThread().name}")
      delay(3000)
      return "Answer 1"
    }

    private suspend fun answer2(): String {
      println("answer2: ${Thread.currentThread().name}")
      delay(3000)
      return "Answer 2"
    }

  }

}
