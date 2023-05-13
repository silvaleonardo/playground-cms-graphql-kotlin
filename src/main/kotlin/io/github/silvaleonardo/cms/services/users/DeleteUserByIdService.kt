package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.UserRespository
import org.springframework.stereotype.Service

@Service
class DeleteUserByIdService(private val userRepository: UserRespository) {

    fun execute(id: Long) {
        val user = userRepository.findById(id)
        if (user.isEmpty()) throw NotFoundException("User not found.")
        userRepository.delete(user.get())
    }
}