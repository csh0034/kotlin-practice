package com.ask.study.kotest

import io.kotest.core.spec.style.AnnotationSpec

internal class AnnotationSpecTest : AnnotationSpec() {

  @BeforeEach
  fun beforeTest() {
    println("Before each test")
  }

  @Test
  fun test1() {
    println("test1")
  }

  @Test
  fun test2() {
    println("test2")
  }
}
