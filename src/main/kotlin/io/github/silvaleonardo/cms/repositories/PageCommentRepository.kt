package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.PageComment
import io.github.silvaleonardo.cms.entities.PageCommentCompositePrimaryKey
import org.springframework.data.jpa.repository.JpaRepository

interface PageCommentRepository: JpaRepository<PageComment, PageCommentCompositePrimaryKey> {
}