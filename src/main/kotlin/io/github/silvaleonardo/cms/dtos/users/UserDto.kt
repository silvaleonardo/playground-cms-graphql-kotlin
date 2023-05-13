package io.github.silvaleonardo.cms.dtos.users

import io.github.silvaleonardo.cms.entities.User

data class UserDto(
    val id: Long?,
    val name: String,
    val email: String,
    val nickname: String
) {
    companion object {
        fun from(user: User) =
            UserDto(
                id = user.id,
                name = user.name,
                email = user.email,
                nickname = user.nickname
            )
    }
}
