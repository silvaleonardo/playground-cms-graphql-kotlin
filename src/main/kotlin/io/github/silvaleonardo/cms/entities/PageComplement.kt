package io.github.silvaleonardo.cms.entities

import io.github.silvaleonardo.cms.dtos.pages.complements.CreatePageComplementPostDto
import io.github.silvaleonardo.cms.dtos.pages.complements.CreatePageComplementReviewDto
import io.github.silvaleonardo.cms.utils.HashMapConverter
import jakarta.persistence.*
import org.hibernate.annotations.ColumnTransformer

@Entity
@Table(name = "page_complements")
data class PageComplement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ColumnTransformer(read = "UPPER(type)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    val type: PageType,
    @Convert(converter = HashMapConverter::class)
    val data: Map<String?, Any?>,
    @Column(name = "page_id")
    val pageId: Long
) {
    companion object {
        fun of(pageComplement: CreatePageComplementPostDto, pageId: Long): PageComplement {
            var data: MutableMap<String?, Any?> = mutableMapOf()
            data += ("attachments" to (pageComplement.attachments ?: ""))
            data += ("more" to (pageComplement.more ?: ""))
            return PageComplement(
                id = null,
                type = PageType.POST,
                data = data,
                pageId = pageId
            )
        }

        fun of(pageComplement: CreatePageComplementReviewDto, pageId: Long): PageComplement {
            var data: MutableMap<String?, Any?> = mutableMapOf()
            data += ("references" to (pageComplement.references ?: ""))
            data += ("rating" to (pageComplement.rating ?: 0))
            data += ("recommend" to (pageComplement.recommend ?: true))
            return PageComplement(
                id = null,
                type = PageType.REVIEW,
                data = data,
                pageId = pageId
            )
        }

    }
}
