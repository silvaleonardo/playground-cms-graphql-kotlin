package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class GetTagByNameService(private val tagRepository: TagRepository) {

    fun execute(name: String): TagDto {
        val tag = tagRepository.findByName(name)
        if (tag.isEmpty()) throw NotFoundException("Tag not found.")
        return TagDto.from(tag.get())
    }
}