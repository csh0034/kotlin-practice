package com.ask.core.step2

import java.time.Instant

class Member(val age: Int, name: String, createDt: Instant) : OpenPerson(name, createDt) {
    override fun toString(): String {
        return "Member(age=$age) ${super.toString()}"
    }
}
