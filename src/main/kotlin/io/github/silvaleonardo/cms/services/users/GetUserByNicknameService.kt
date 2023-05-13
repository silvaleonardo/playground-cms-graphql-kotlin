package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.UserRespository
import org.springframework.stereotype.Service

@Service
class GetUserByNicknameService(private val userRespository: UserRespository) {

    fun execute(nickname: String): UserDto {
        val user = userRespository.findByNickname(nickname)
        if (user.isEmpty()) throw NotFoundException("User not found.")
        return UserDto.from(user.get())
    }
}