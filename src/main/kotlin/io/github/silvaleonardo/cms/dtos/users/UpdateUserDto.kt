package io.github.silvaleonardo.cms.dtos.users

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class UpdateUserDto(
    @field:Size(min = 2, max = 100)
    val name: String?,
    @field:Email
    @field:Size(min = 2, max = 100)
    val email: String?
)
