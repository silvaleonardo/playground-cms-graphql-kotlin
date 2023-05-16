package io.github.silvaleonardo.cms.resolvers.pages

import io.github.silvaleonardo.cms.dtos.pages.CreatePageDto
import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.pages.UpdatePageDto
import io.github.silvaleonardo.cms.services.pages.CreatePageService
import io.github.silvaleonardo.cms.services.pages.DeletePageByIdService
import io.github.silvaleonardo.cms.services.pages.UpdatePageByIdService
import jakarta.validation.Valid
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
    fun createPage(@Valid @Argument(name = "input") input: CreatePageDto, @ContextValue(name = "userToken") userToken: String): PageDto =
        createPageService.execute(input, userToken)

    @MutationMapping
    fun updatePageById(@Argument(name = "id") id: Long, @Valid @Argument(name = "input") input: UpdatePageDto): PageDto =
        updatePageByIdService.execute(id, input)

    @MutationMapping
    fun deletePageById(@Argument(name = "id") id: Long): Boolean {
        deletePageByIdService.execute(id)
        return true
    }
}