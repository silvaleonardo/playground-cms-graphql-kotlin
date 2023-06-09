package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {

    fun findByNickname(nickname: String): Optional<User>
    fun findByEmail(email: String): Optional<User>
    fun findByNicknameAndEmail(nickname: String, email: String): Optional<User>
    fun findByToken(token: String): Optional<User>
}