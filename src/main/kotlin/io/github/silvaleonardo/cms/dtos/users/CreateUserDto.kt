package io.github.silvaleonardo.cms.dtos.users

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUserDto(
    @field:NotBlank
    @field:Size(min = 2, max = 100)
    val name: String,
    @field:NotNull
    @field:Email
    @field:Size(min = 2, max = 100)
    val email: String,
    @field:NotBlank
    @field:Size(min = 2, max = 100)
    val nickname: String
)
