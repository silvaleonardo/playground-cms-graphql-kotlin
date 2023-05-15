package io.github.silvaleonardo.cms.dtos.tags

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateTagDto(
    @field:NotBlank
    @field:Size(min = 2, max = 100)
    val name: String
)
