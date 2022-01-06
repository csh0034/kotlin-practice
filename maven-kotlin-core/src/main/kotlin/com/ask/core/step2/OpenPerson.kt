package com.ask.core.step2

import java.io.Serializable
import java.time.Instant

open class OpenPerson(
    val name: String,
    val createDt: Instant
) : Serializable,
    Comparable<OpenPerson> {
    override fun compareTo(other: OpenPerson) = 0
    override fun toString(): String = "OpenPerson(name='$name', createDt=$createDt)"
}
