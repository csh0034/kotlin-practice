package com.ask.webfluxcoroutines.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "mt_endpoint")
class Endpoint(

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "user_id")
  var id: String? = null,

  @Column(nullable = false, unique = true, length = 30)
  var serial: String,

  @Column(length = 30)
  var name: String?

) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
    other as Endpoint

    return id == other.id
  }

  override fun hashCode(): Int {
    return id.hashCode()
  }

  override fun toString(): String {
    return "Endpoint(id=$id, name='$name')"
  }

}
