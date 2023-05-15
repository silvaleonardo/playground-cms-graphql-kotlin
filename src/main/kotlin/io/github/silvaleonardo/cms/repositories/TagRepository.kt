package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface TagRepository: JpaRepository<Tag, Long> {

    fun findByName(name: String): Optional<Tag>

    @Query("SELECT t FROM PageTag pt INNER JOIN Tag t ON (t.id = pt.id.tagId) WHERE pt.id.pageId = :pageId")
    fun findByPageId(pageId: Long): List<Tag>
}