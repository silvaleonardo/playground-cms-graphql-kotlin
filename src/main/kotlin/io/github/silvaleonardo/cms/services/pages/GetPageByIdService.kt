package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.PageRepository
import org.springframework.stereotype.Service

@Service
class GetPageByIdService(private val pageRepository: PageRepository) {

    fun execute(id: Long): PageDto {
        val page = pageRepository.findById(id)
        if (page.isEmpty()) throw NotFoundException("Page not found.")
        return PageDto.from(page.get())
    }
}