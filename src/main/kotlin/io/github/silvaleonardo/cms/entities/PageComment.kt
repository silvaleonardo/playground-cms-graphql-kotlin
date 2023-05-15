package io.github.silvaleonardo.cms.entities

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "pages_comments")
data class PageComment(
    @EmbeddedId
    val id: PageCommentCompositePrimaryKey
)

@Embeddable
data class PageCommentCompositePrimaryKey(
    @Column(name = "page_id")
    val pageId: Long,
    @Column(name = "comment_id")
    val commentId: Long
)
