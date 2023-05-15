package io.github.silvaleonardo.cms.dtos.pages

import io.github.silvaleonardo.cms.entities.PageStatus
import io.github.silvaleonardo.cms.validators.PageStatusNotDeleted
import jakarta.validation.constraints.Size

data class UpdatePageDto(
    @field:Size(max = 255)
    val summary: String?,
    val body: String?,
    @field:PageStatusNotDeleted
    val status: PageStatus?
)
