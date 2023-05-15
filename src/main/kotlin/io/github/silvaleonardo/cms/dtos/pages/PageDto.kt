package io.github.silvaleonardo.cms.dtos.pages

import io.github.silvaleonardo.cms.entities.Page
import io.github.silvaleonardo.cms.entities.PageStatus
import java.time.LocalDateTime

data class PageDto(
    val id: Long?,
    val title : String,
    val summary: String?,
    val body: String?,
    val status: PageStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: Long
) {
    companion object {
        fun from (page: Page): PageDto =
            PageDto(
                id = page.id,
                title = page.title,
                summary = page.summary,
                body = page.body,
                status = page.status,
                createdAt = page.createdAt,
                updatedAt = page.updatedAt,
                userId = page.userId
            )
    }
}
