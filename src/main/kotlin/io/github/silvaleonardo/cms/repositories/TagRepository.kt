package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<Tag, Long> {
}