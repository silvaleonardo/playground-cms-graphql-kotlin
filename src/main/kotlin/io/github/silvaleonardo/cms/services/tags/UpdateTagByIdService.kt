package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.dtos.tags.UpdateTagDto
import io.github.silvaleonardo.cms.entities.Tag
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class UpdateTagByIdService(private val tagRepository: TagRepository) {

    fun execute(id: Long, updateTagDto: UpdateTagDto): TagDto {
        val tag = tagRepository.findById(id)
        if (tag.isEmpty()) throw NotFoundException("Tag not found.")
        val tagUpdated = tagRepository.save(
            Tag(
            id = tag.get().id,
            name = updateTagDto.name
        )
        )
        return TagDto.from(tagUpdated)
    }
}