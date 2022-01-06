package com.ask.core.step2

object ObjectDataMemberFactory {

    val members = mutableListOf<DataMember>()

    fun create(name: String): DataMember {
        val dataMember = DataMember(name)
        members.add(dataMember)
        return dataMember
    }
}