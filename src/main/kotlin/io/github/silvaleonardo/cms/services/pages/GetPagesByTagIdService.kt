package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.repositories.PageRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetPagesByTagIdService(private val pageRepository: PageRepository) {

    fun execute(tagId: Long, page: Int = 1, size: Int = 10): List<PageDto> {
        val paging = if (page > 0)  (page -1) else 0
        val pageable: Pageable = PageRequest.of(paging, size)
        val pages = pageRepository.findByTagId(tagId, pageable)
        return pages.map { it -> PageDto.from(it) }.toList()
    }
}