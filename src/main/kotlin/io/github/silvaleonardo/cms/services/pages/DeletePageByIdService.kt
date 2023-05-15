package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.entities.Page
import io.github.silvaleonardo.cms.entities.PageStatus
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.PageRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeletePageByIdService(private val pageRepository: PageRepository) {

    fun execute(id: Long) {
        val page = pageRepository.findById(id)
        if (page.isEmpty()) throw NotFoundException("Page not found.")
        pageRepository.save(
            Page(
                id = page.get().id,
                title =  page.get().title,
                summary = page.get().summary,
                body = page.get().body,
                status = PageStatus.DELETED,
                createdAt = page.get().createdAt,
                updatedAt = LocalDateTime.now(),
                deletedAt = LocalDateTime.now(),
                userId = page.get().userId
            )
        )
    }
}