package io.github.silvaleonardo.cms.dtos.tags

import io.github.silvaleonardo.cms.entities.Tag

data class TagDto(
    val id: Long,
    val name: String
) {
    companion object {
        fun from(tag: Tag): TagDto =
            TagDto(
                id = tag.id,
                name = tag.name
            )
    }
}
