package io.github.silvaleonardo.cms.dtos.pages

import io.github.silvaleonardo.cms.entities.PageStatus
import io.github.silvaleonardo.cms.validators.PageStatusNotDeleted
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreatePageDto(
    @field:NotBlank
    @field:Size(min = 2, max = 255)
    val title: String,
    @field:Size(max = 255)
    val summary: String?,
    val body: String?,
    @field:PageStatusNotDeleted
    val status: PageStatus?,
    val tagIds: List<Long>?
)
