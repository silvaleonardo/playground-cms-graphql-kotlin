package io.github.silvaleonardo.cms.dtos.pages.complements

import jakarta.validation.constraints.Size

data class CreatePageComplementPostDto(
    @field:Size(min = 2, max = 255)
    val attachments: String?,
    @field:Size(min = 2, max = 255)
    val more: String?
)
