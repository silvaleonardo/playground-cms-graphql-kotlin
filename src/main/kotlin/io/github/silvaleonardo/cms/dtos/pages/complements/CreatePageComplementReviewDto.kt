package io.github.silvaleonardo.cms.dtos.pages.complements

import jakarta.validation.constraints.Size

data class CreatePageComplementReviewDto(
    @field:Size(min = 2, max = 255)
    val references: String?,
    val rating: Double?,
    val recommend: Boolean?
)
