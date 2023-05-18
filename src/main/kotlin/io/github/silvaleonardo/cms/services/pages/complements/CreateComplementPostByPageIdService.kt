package io.github.silvaleonardo.cms.services.pages.complements

import io.github.silvaleonardo.cms.dtos.pages.complements.CreatePageComplementPostDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementPostDto
import io.github.silvaleonardo.cms.entities.PageComplement
import io.github.silvaleonardo.cms.repositories.PageComplementRepository
import org.springframework.stereotype.Service

@Service
class CreateComplementPostByPageIdService(val pageComplementRepository: PageComplementRepository) {

    fun execute(pageId: Long, createComplement: CreatePageComplementPostDto): PageComplementPostDto {
        var pageComplement = PageComplement.of(createComplement, pageId)
        pageComplement = pageComplementRepository.save(pageComplement)
        return PageComplementPostDto.from(pageComplement)
    }
}