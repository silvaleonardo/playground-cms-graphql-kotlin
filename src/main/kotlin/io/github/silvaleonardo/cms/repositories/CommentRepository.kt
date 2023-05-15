package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CommentRepository: JpaRepository<Comment, Long> {

    fun findByUserId(userId: Long, pageable: Pageable): Page<Comment>
    fun findByCommentId(commentId: Long, pageable: Pageable): Page<Comment>

    @Query("SELECT c FROM PageComment pc INNER JOIN Comment c ON (c.id = pc.id.commentId) WHERE pc.id.pageId = :pageId")
    fun findByPageId(pageId: Long, pageable: Pageable): Page<Comment>
}