package io.github.silvaleonardo.cms.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val email: String,
    val nickname: String
)
