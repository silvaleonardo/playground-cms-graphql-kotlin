package io.github.silvaleonardo.cms.resolvers.pages

import io.github.silvaleonardo.cms.dtos.pages.CreatePageDto
import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.pages.UpdatePageDto
import io.github.silvaleonardo.cms.services.pages.CreatePageService
import io.github.silvaleonardo.cms.services.pages.DeletePageByIdService
import io.github.silvaleonardo.cms.services.pages.UpdatePageByIdService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.ContextValue
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class PageMutationResolver(
    private val createPageService: CreatePageService,
    private val updatePageByIdService: UpdatePageByIdService,
    private val deletePageByIdService: DeletePageByIdService
) {

    @MutationMapping
    fun createPage(@Argument(name = "input") input: CreatePageDto, @ContextValue(name = "userToken") userToken: String): PageDto {
        return createPageService.execute(input, userToken)
    }

    @MutationMapping
    fun updatePageById(@Argument(name = "id") id: Long, @Argument(name = "input") input: UpdatePageDto): PageDto {
        return updatePageByIdService.execute(id, input)
    }

    @MutationMapping
    fun deletePageById(@Argument(name = "id") id: Long): Boolean {
        deletePageByIdService.execute(id)
        return true
    }
}