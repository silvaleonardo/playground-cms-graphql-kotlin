package io.github.silvaleonardo.cms.entities

import jakarta.persistence.*
import org.hibernate.annotations.ColumnTransformer
import java.util.Date

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val body: String?,
    @ColumnTransformer(read = "UPPER(status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    val status: CommentStatus,
    @Column(name = "created_at")
    val createdAt: Date,
    @Column(name = "updated_at")
    val updatedAt: Date,
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "comment_id")
    val commentId: Long?
)
