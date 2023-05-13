package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.CreateUserDto
import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.entities.User
import io.github.silvaleonardo.cms.repositories.UserRespository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateUserService(private val userRespository: UserRespository) {

    fun execute(createUserDto: CreateUserDto): UserDto {
        var user = User.of(createUserDto)
        user.token = UUID.randomUUID().toString()
        user = userRespository.save(user)
        return UserDto.from(user)
    }
}