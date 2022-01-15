package com.ask.kotlinspring.repository

import com.ask.kotlinspring.vo.UserVO

interface UserRepositoryCustom {

    fun findAllByCompanyName(companyName: String): MutableList<UserVO>
}
