package io.github.silvaleonardo.cms.resolvers.pages

import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.pages.PageSearchDto
import io.github.silvaleonardo.cms.services.pages.*
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class PageQueryResolver(
    private val getPagesService: GetPagesService,
    private val getPagesByUserIdService: GetPagesByUserIdService,
    private val getPagesByTagIdService: GetPagesByTagIdService,
    private val searchPagesService: SearchPagesService,
    private val getPageByIdService: GetPageByIdService
) {

    @QueryMapping
    fun getPages(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<PageDto> {
        return getPagesService.execute(page, size)
    }

    @QueryMapping
    fun getPagesByUserId(@Argument(name = "userId") userId: Long, @Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<PageDto> {
        return getPagesByUserIdService.execute(userId, page, size)
    }

    @QueryMapping
    fun getPagesByTagId(@Argument(name = "tagId") tagId: Long, @Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<PageDto> {
        return getPagesByTagIdService.execute(tagId, page, size)
    }

    @QueryMapping
    fun searchPages(@Argument(name = "where") where: PageSearchDto, @Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<PageDto> {
        return searchPagesService.execute(where, page, size)
    }

    @QueryMapping
    fun getPageById(@Argument(name = "id") id: Long): PageDto {
        return getPageByIdService.execute(id)
    }
}