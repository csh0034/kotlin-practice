package com.ask.core

class Function {

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // expression syntax (식 구문)
    fun sum(a: Int, b: Int) = a + b

    // Elvis operator
    fun getLen(str: String?) = str?.length ?: 0
}
