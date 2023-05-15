package io.github.silvaleonardo.cms.services.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.repositories.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetUsersService(private val userRepository: UserRepository) {

    fun execute(page: Int = 1, size: Int = 10): List<UserDto> {
        val paging = if (page > 0)  (page -1) else 0
        val pageable: Pageable = PageRequest.of(paging, size)
        val results = userRepository.findAll(pageable)
        return results.map { it -> UserDto.from(it) }.toList()
    }
}