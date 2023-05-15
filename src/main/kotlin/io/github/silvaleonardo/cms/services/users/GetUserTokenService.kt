package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.exceptions.UnauthorizedException
import io.github.silvaleonardo.cms.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUserTokenService(private val userRepository: UserRepository) {

    fun execute(nickname: String, email: String): String {
        val user = userRepository.findByNicknameAndEmail(nickname, email)
        if (user.isEmpty()) throw UnauthorizedException()
        return user.get().token.toString()
    }
}