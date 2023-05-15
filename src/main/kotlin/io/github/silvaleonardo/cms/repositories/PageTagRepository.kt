package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.PageTag
import io.github.silvaleonardo.cms.entities.PageTagCompositePrimaryKey
import org.springframework.data.jpa.repository.JpaRepository

interface PageTagRepository: JpaRepository<PageTag, PageTagCompositePrimaryKey> {
}