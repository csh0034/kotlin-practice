package com.ask.kotlinspring.domain

import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "mt_user")
class User(

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    var id: String? = null,

    @Column(nullable = false, length = 30)
    var loginId: String,

    @Column(nullable = false, length = 30)
    var name: String,

    @Column(nullable = false, length = 100)
    var password: String,

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    var role: Role
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "User(id='$id', loginId='$loginId', name='$name', password='$password')"
    }

    enum class Role {
        ROLE_USER, ROLE_ADMIN
    }
}
