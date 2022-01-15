package com.ask.kotlinspring.repository

import com.ask.kotlinspring.domain.QCompany.company
import com.ask.kotlinspring.domain.QUser.user
import com.ask.kotlinspring.vo.QUserVO
import com.ask.kotlinspring.vo.UserVO
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : UserRepositoryCustom {

    override fun findAllByCompanyName(companyName: String): MutableList<UserVO> {
        return queryFactory
            .select(
                QUserVO(
                    user.id,
                    user.name,
                    company.name
                )
            )
            .from(user)
            .join(user.company, company)
            .where(company.name.eq(companyName))
            .fetch()
    }
}
