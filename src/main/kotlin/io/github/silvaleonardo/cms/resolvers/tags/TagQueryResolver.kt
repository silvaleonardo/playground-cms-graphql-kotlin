package io.github.silvaleonardo.cms.resolvers.tags

import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.services.tags.GetTagByIdService
import io.github.silvaleonardo.cms.services.tags.GetTagsService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class TagQueryResolver(
    private val getTagsService: GetTagsService,
    private val getTagByIdService: GetTagByIdService
) {

    @QueryMapping
    fun getTags(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<TagDto> {
        return getTagsService.execute(page, size)
    }

    @QueryMapping
    fun getTagById(@Argument(name = "id") id: Long): TagDto {
        return getTagByIdService.execute((id))
    }
}