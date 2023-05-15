package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.pages.UpdatePageDto
import io.github.silvaleonardo.cms.entities.Page
import io.github.silvaleonardo.cms.entities.PageStatus
import io.github.silvaleonardo.cms.exceptions.BadRequestException
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.PageRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UpdatePageByIdService(private val pageRepository: PageRepository) {

    fun execute(id: Long, updatePageDto: UpdatePageDto): PageDto {
        if (updatePageDto.status == PageStatus.DELETED) throw BadRequestException("Unable to update page to status DELETED.")
        val page = pageRepository.findById(id)
        if (page.isEmpty()) throw NotFoundException("Page not found.")
        val pageUpdated = pageRepository.save(Page(
            id = page.get().id,
            title =  page.get().title,
            summary = updatePageDto.summary ?: page.get().summary,
            body = updatePageDto.body ?: page.get().body,
            status = updatePageDto.status ?: page.get().status,
            createdAt = page.get().createdAt,
            updatedAt = LocalDateTime.now(),
            deletedAt = page.get().deletedAt,
            userId = page.get().userId

        ))
        return PageDto.from(pageUpdated)
    }
}