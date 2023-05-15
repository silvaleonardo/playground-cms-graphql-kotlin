package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class GetTagByIdService(private val tagRepository: TagRepository) {

    fun execute(id: Long): TagDto {
        val tag = tagRepository.findById(id)
        if (tag.isEmpty()) throw NotFoundException("Tag not found.")
        return TagDto.from(tag.get())
    }
}