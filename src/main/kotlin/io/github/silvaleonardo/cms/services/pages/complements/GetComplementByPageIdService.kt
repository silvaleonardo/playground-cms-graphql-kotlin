package io.github.silvaleonardo.cms.services.pages.complements

import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementPostDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementReviewDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementDto
import io.github.silvaleonardo.cms.entities.PageType
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.PageComplementRepository
import org.springframework.stereotype.Service

@Service
class GetComplementByPageIdService(private val pageComplementRepository: PageComplementRepository) {

    fun execute(pageId: Long): PageComplementDto? {
        val result = this.pageComplementRepository.findByPageId(pageId)
        if (result.isEmpty()) return null
        var pageComplement = result.get()
        return when(pageComplement.type) {
            PageType.POST ->
                PageComplementPostDto.from(pageComplement)
            PageType.REVIEW ->
                PageComplementReviewDto.from(pageComplement)
        }
    }
}