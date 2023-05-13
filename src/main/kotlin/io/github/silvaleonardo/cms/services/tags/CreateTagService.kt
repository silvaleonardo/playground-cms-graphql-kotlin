package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.CreateTagDto
import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.entities.Tag
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class CreateTagService(private val tagRepository: TagRepository) {

    fun execute(createTagDto: CreateTagDto): TagDto {
        var tag = Tag.of(createTagDto)
        tag = tagRepository.save(tag)
        return TagDto.from(tag)
    }
}