package io.github.silvaleonardo.cms.entities

import io.github.silvaleonardo.cms.dtos.comments.CreateCommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentReplyDto
import jakarta.persistence.*
import org.hibernate.annotations.ColumnTransformer
import java.time.LocalDateTime

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    val body: String?,
    @ColumnTransformer(read = "UPPER(status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    val status: CommentStatus,
    @Column(name = "created_at")
    val createdAt: LocalDateTime,
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
    @Column(name = "deleted_at")
    val deletedAt: LocalDateTime?,
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "comment_id")
    val commentId: Long?
) {
    companion object {
        fun of(createCommentDto: CreateCommentDto): Comment =
            Comment(
                id = null,
                title = createCommentDto.title,
                body = createCommentDto.body ?: null,
                status = CommentStatus.ACTIVATED,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
                deletedAt = null,
                userId = createCommentDto.userId,
                commentId = null
            )

        fun of(createCommentReplyDto: CreateCommentReplyDto): Comment =
            Comment(
                id = null,
                title = createCommentReplyDto.title,
                body = createCommentReplyDto.body ?: null,
                status = CommentStatus.ACTIVATED,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
                deletedAt = null,
                userId = createCommentReplyDto.userId,
                commentId = createCommentReplyDto.commentId
            )
    }
}
