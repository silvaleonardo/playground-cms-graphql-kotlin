package io.github.silvaleonardo.cms.entities

import io.github.silvaleonardo.cms.dtos.users.CreateUserDto
import io.github.silvaleonardo.cms.dtos.users.UpdateUserDto
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var name: String,
    var email: String,
    val nickname: String
) {
    companion object {
        fun of(createUserDto: CreateUserDto): User =
            User(
                id = null,
                name = createUserDto.name,
                email = createUserDto.email,
                nickname = createUserDto.nickname
            )
    }
}
