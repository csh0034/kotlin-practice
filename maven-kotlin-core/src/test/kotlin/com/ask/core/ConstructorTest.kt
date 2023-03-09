package com.ask.core

import org.junit.jupiter.api.Test

class ConstructorTest {

  @Test
  fun constructor() {
    val e = E("constructor", 100, 200)
    println(e)
  }

}

class E {

  var name: String
  var age: Int = 1
  var height: Int = 2

  init {
    println("call Init Block!")
  }

  constructor(name: String) {
    this.name = name
    println("call Name Constructor!")
  }

  constructor(name: String, age: Int) : this(name) {
    this.age = age
    println("call Name, Age Constructor!")
  }

  constructor(name: String, age: Int, height: Int) : this(name, age) {
    this.height = height
    println("call Name, Age, Height Constructor!")
  }

  override fun toString(): String {
    return "E(name='$name', age=$age, height=$height)"
  }

}
