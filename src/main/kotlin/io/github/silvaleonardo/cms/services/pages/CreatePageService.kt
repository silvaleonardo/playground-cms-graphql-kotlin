package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.dtos.pages.CreatePageDto
import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.entities.Page
import io.github.silvaleonardo.cms.entities.PageStatus
import io.github.silvaleonardo.cms.entities.PageTag
import io.github.silvaleonardo.cms.entities.PageTagCompositePrimaryKey
import io.github.silvaleonardo.cms.exceptions.BadRequestException
import io.github.silvaleonardo.cms.exceptions.UnauthorizedException
import io.github.silvaleonardo.cms.repositories.PageRepository
import io.github.silvaleonardo.cms.repositories.PageTagRepository
import io.github.silvaleonardo.cms.services.tags.GetTagByIdService
import io.github.silvaleonardo.cms.services.users.GetUserByTokenService
import org.springframework.stereotype.Service
import kotlin.Exception

@Service
class CreatePageService(
    private val pageRepository: PageRepository,
    private val pageTagRepository: PageTagRepository,
    private val getUserByTokenService: GetUserByTokenService,
    private val getTagByIdService: GetTagByIdService
) {

    fun execute(createPageDto: CreatePageDto, userToken: String): PageDto {
        if (createPageDto.status == PageStatus.DELETED) throw BadRequestException("Unable to create page with status DELETED.")
        val user = try { getUserByTokenService.execute(userToken) } catch (e: Exception) { throw UnauthorizedException() }
        var page = Page.of(createPageDto, user.id!!)
        page = pageRepository.save(page)
        if (!createPageDto.tagIds.isNullOrEmpty()) {
            createPageDto.tagIds.distinct().map { tagId ->
                try {
                    getTagByIdService.execute(tagId)
                    pageTagRepository.save(PageTag(
                        id = PageTagCompositePrimaryKey(
                            pageId = page.id!!,
                            tagId = tagId
                        )
                    ))
                } catch (e: Exception) {}
            }
        }
        return PageDto.from(page)
    }
}