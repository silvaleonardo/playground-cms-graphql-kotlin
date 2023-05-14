package io.github.silvaleonardo.cms.dtos.comments

import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.entities.CommentStatus
import java.time.LocalDateTime

data class CommentDto(
    val id: Long?,
    val title: String,
    val body: String?,
    val status: CommentStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: Long
) {
    companion object {
        fun from(comment: Comment): CommentDto =
            CommentDto(
                id = comment.id,
                title = comment.title,
                body = comment.body,
                status = comment.status,
                createdAt = comment.createdAt,
                updatedAt = comment.updatedAt,
                userId = comment.userId
            )
    }
}
