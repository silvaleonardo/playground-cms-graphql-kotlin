package io.github.silvaleonardo.cms.dtos.comments

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateCommentDto(
    @field:NotNull
    val pageId: Long,
    @field:NotBlank
    @field:Size(min = 2, max = 255)
    val title: String,
    @field:Size(max = 255)
    val body: String?
)
