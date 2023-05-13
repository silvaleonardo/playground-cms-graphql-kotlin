package io.github.silvaleonardo.cms.dtos.users

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUserDto(
    @NotBlank
    @Size(min = 2, max = 100)
    val name: String,
    @NotNull
    @Email
    @Size(min = 2, max = 100)
    val email: String,
    @NotBlank
    @Size(min = 2, max = 100)
    val nickname: String
)
