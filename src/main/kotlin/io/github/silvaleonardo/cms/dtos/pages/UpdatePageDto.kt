package io.github.silvaleonardo.cms.dtos.pages

import io.github.silvaleonardo.cms.entities.PageStatus
import jakarta.validation.constraints.Size

data class UpdatePageDto(
    @Size(max = 255)
    val summary: String?,
    val body: String?,
    val status: PageStatus?
)
