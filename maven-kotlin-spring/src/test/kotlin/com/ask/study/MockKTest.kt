package com.ask.study

import com.ask.study.Bar.bar
import com.ask.support.UnitTest
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.shouldBe
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

class Foo {
  fun String.foo(value: String) {}

  fun foo(value: String) {
    throw RuntimeException()
  }
}

object Bar {
  fun String.bar(value: String) {}
}

fun String.baz(value: String) {}

fun Foo.baz(value: String) {
  println("baz")
  foo(value)
}

@UnitTest
internal class MockKTest(
  @MockK private val foo: Foo
) {

  @Test
  fun `다른 클래스에서 선언된 확장 함수를 스텁할 수 있다`() {
    with(foo) {
      every { "first".foo(any()) } answers {
        firstArg<String>() shouldBe "first"
        secondArg<String>() shouldBe "second"
      }
      "first".foo("second")
    }
  }

  @Test
  fun `객체에 선언된 확장 함수를 스텁할 수 있다`() {
    mockkObject(Bar)
    every { "first".bar(any()) } answers {
      firstArg<String>() shouldBe "first"
      secondArg<String>() shouldBe "second"
    }
    "first".bar("second")
    unmockkObject(Bar)
  }

  @Test
  fun `최상위 확장 함수를 스텁할 수 있다`() {
    mockkStatic("com.ask.study.MockKTestKt")
    every { "first".baz("second") } answers {
      firstArg<String>() shouldBe "first"
      secondArg<String>() shouldBe "second"
    }
    "first".baz("second")
    unmockkStatic("com.ask.study.MockKTestKt")
  }

  @Test
  fun `최상위 확장 함수가 아닌 내부에서 호출되는 모의 객체의 함수를 스텁한다`() {
    val foo = mockk<Foo>()
    every { foo.baz(any()) } answers {
      firstArg<String>() shouldBe "first"
    }
    shouldNotThrowAny { foo.foo("first") }
    verify { foo.foo(any()) }
  }
}
