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



  }

}
