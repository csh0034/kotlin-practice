package com.ask.core.step2

data class CompanionMember(val name: String, val age: Int = 5) {

    companion object {
        fun returnXml(xml: String) = xml

        fun create(xml: String): CompanionMember {
            TODO("미구현!!!")
        }
    }
}