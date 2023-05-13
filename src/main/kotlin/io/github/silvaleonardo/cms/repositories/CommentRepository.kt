package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Comment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {

    fun findByUserId(userId: Long, pageable: Pageable): Page<Comment>
}