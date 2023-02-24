package com.ask.study.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.isRootTest

internal class LifecycleHookTest : BehaviorSpec({
  beforeSpec {
    println("beforeSpec #1")
  }

  beforeContainer {
    println("beforeContainer #2")
  }

  beforeAny {
    println("beforeAny #3")
  }

  beforeTest {
    println("beforeTest #4")
  }

  afterTest {
    val (testcase) = it
    if (testcase.isRootTest()) {
      println("afterRootTest #5")
    }
  }

  afterTest {
    println("afterTest #6")
  }


  afterAny {
    println("afterAny #7")
  }

  afterContainer {
    println("afterContainer #8")
  }

  afterSpec {
    println("afterSpec #9")
  }

  Given("given1") {
    When("when1") {
      Then("then1") {
        println("given1-when1-then1")
      }
      Then("then2") {
        println("given1-when1-then2")
      }
    }
    When("when2") {
      Then("then1") {
        println("given1-when2-then1")
      }
      Then("then2") {
        println("given1-when2-then2")
      }
    }
  }

  Given("given2") {
    When("when1") {
      Then("then1") {
        println("given2-when1-then1")
      }
      Then("then2") {
        println("given2-when1-then2")
      }
    }
    When("when2") {
      Then("then1") {
        println("given2-when2-then1")
      }
      Then("then2") {
        println("given2-when2-then2")
      }
    }
  }
})
