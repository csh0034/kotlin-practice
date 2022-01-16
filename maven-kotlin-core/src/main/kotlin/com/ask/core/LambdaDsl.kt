package com.ask.core

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var job: Job? = null,
)

data class Job(
    var category: String? = null,
    var position: String? = null,
)

fun person1(block: (Person) -> Unit): Person {
    val person = Person()
    block(person)
    return person
}

fun person2(block: Person.() -> Unit): Person {
    val person = Person()
    person.block()
    return person
}

fun person3(block: Person.() -> Unit) = Person().apply(block)

fun Person.job(block: Job.() -> Unit) {
    job = Job().apply(block)
}
