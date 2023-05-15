package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Tag
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TagRepository: JpaRepository<Tag, Long> {

    fun findByName(name: String): Optional<Tag>
}