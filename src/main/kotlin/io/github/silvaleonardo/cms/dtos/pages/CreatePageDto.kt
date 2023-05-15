package io.github.silvaleonardo.cms.dtos.pages

import io.github.silvaleonardo.cms.entities.PageStatus
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreatePageDto(
    @NotBlank
    @Size(min = 2, max = 255)
    val title: String,
    @Size(max = 255)
    val summary: String?,
    val body: String?,
    val status: PageStatus?,
    val tagIds: List<Long>?
)
