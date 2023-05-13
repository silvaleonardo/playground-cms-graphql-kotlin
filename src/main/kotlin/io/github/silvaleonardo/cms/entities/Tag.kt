package io.github.silvaleonardo.cms.entities

import io.github.silvaleonardo.cms.dtos.tags.CreateTagDto
import jakarta.persistence.*

@Entity
@Table(name = "tags")
data class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String
) {
    companion object {
        fun of(createTagDto: CreateTagDto): Tag =
            Tag(
                id = null,
                name = createTagDto.name
            )
    }
}
