package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserByEmailService(private val userRepository: UserRepository) {

    fun execute(email: String): UserDto {
        val user = userRepository.findByEmail(email)
        if (user.isEmpty()) throw NotFoundException("User not found.")
        return UserDto.from(user.get())
    }
}