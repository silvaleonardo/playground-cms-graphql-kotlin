package io.github.silvaleonardo.cms.entities

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "pages_tags")
data class PageTag(
    @EmbeddedId
    val id: PageTagCompositePrimaryKey
)

@Embeddable
data class PageTagCompositePrimaryKey(
    @Column(name = "page_id")
    val pageId: Long,
    @Column(name = "tag_id")
    val tagId: Long
)