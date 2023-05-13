package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetTagsService(private val tagRepository: TagRepository) {

    fun execute(page: Int = 1, size: Int = 10): List<TagDto> {
        val paging = if (page > 0)  (page -1) else 0
        val pageable: Pageable = PageRequest.of(paging, size)
        val tags = tagRepository.findAll(pageable)
        return tags.map { it -> TagDto.from(it) }.toList()
    }
}