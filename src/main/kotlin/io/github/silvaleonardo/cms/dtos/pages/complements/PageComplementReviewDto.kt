package io.github.silvaleonardo.cms.dtos.pages.complements

data class PageComplementReviewDto(
    val references: String?,
    val rating: Double?,
    val recommend: Boolean?
): PageComplementDto {
    companion object {
        fun from(pageComplement: io.github.silvaleonardo.cms.entities.PageComplement): PageComplementReviewDto =
            PageComplementReviewDto(
                references = pageComplement.data.get("references").toString(),
                rating = pageComplement.data.get("rating").toString().toDouble(),
                recommend = pageComplement.data.get("recommend").toString().toBoolean(),
            )
    }
}
