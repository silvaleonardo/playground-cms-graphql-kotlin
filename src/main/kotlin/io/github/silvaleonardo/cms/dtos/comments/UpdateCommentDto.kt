package io.github.silvaleonardo.cms.dtos.comments

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateCommentDto(
    @NotBlank
    @Size(min = 2, max = 255)
    val title: String?,
    @Size(max = 255)
    val body: String?
)
