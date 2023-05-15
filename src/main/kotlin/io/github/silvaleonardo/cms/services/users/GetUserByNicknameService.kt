package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserByNicknameService(private val userRepository: UserRepository) {

    fun execute(nickname: String): UserDto {
        val user = userRepository.findByNickname(nickname)
        if (user.isEmpty()) throw NotFoundException("User not found.")
        return UserDto.from(user.get())
    }
}