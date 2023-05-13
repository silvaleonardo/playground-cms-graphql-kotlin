package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.UpdateUserDto
import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.entities.User
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.UserRespository
import org.springframework.stereotype.Service

@Service
class UpdateUserByIdService(private val userRepository: UserRespository) {

    fun execute(id: Long, updateUserDto: UpdateUserDto): UserDto {
        val user = userRepository.findById(id)
        if (user.isEmpty()) throw NotFoundException("User not found.")
        val userUpdated = userRepository.save(User(
            id = user.get().id,
            name = updateUserDto.name ?: user.get().name,
            email = updateUserDto.email ?: user.get().email,
            nickname = user.get().nickname,
            token = user.get().token
        ))
        return UserDto.from(userUpdated)
    }
}