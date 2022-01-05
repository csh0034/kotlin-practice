package com.ask.core

class Function {

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun sum(a: Int, b: Int) = a + b

    // Elvis operator
    fun getLen(str: String?): Int = str?.length ?: 0
}
