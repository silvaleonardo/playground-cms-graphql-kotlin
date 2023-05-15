package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PageRepository: JpaRepository<Page, Long> {

    fun findByUserId(userId: Long, pageable: Pageable): org.springframework.data.domain.Page<Page>

    @Query("SELECT p FROM PageTag pt INNER JOIN Page p ON (p.id = pt.id.pageId) WHERE pt.id.tagId = :tagId")
    fun findByTagId(tagId: Long, pageable: Pageable): org.springframework.data.domain.Page<Page>
}