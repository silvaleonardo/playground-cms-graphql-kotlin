package io.github.silvaleonardo.cms.services.pages.complements

import io.github.silvaleonardo.cms.dtos.pages.complements.CreatePageComplementReviewDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementReviewDto
import io.github.silvaleonardo.cms.entities.PageComplement
import io.github.silvaleonardo.cms.repositories.PageComplementRepository
import org.springframework.stereotype.Service

@Service
class CreateComplementReviewByPageIdService(val pageComplementRepository: PageComplementRepository) {

    fun execute(pageId: Long, createComplement: CreatePageComplementReviewDto): PageComplementReviewDto {
        var pageComplement = PageComplement.of(createComplement, pageId)
        pageComplement = pageComplementRepository.save(pageComplement)
        return PageComplementReviewDto.from(pageComplement)
    }
}