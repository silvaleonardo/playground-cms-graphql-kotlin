package io.github.silvaleonardo.cms.dtos.pages.complements

data class PageComplementPostDto(
    val attachments: String?,
    val more: String?
): PageComplementDto {
    companion object {
        fun from(pageComplement: io.github.silvaleonardo.cms.entities.PageComplement): PageComplementPostDto =
            PageComplementPostDto(
                attachments = pageComplement.data.get("attachments").toString(),
                more = pageComplement.data.get("more").toString(),
            )
    }
}
