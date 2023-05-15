package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class GetTagsByPageIdService(private val tagRepository: TagRepository) {

    fun execute(pageId: Long): List<TagDto> {
        val tags = tagRepository.findByPageId(pageId)
        return tags.map { it -> TagDto.from(it) }.toList()
    }
}