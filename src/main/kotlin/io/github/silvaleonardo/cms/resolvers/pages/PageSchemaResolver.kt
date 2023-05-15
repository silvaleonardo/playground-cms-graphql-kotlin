package io.github.silvaleonardo.cms.resolvers.pages

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.services.comments.GetCommentsByPageIdService
import io.github.silvaleonardo.cms.services.tags.GetTagsByPageIdService
import io.github.silvaleonardo.cms.services.users.GetUserByIdService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class PageSchemaResolver(
    private val getUserByIdService: GetUserByIdService,
    private val getTagsByPageIdService: GetTagsByPageIdService,
    private val getCommentsByPageIdService: GetCommentsByPageIdService
) {

    @SchemaMapping(typeName = "Page", field = "user")
    fun user(pageDto: PageDto): UserDto {
        return getUserByIdService.execute(pageDto.userId)
    }

    @SchemaMapping(typeName = "Page", field = "comments")
    fun comments(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int, pageDto: PageDto): List<CommentDto> {
        return getCommentsByPageIdService.execute(pageDto.id!!, page, size)
    }

    @SchemaMapping(typeName = "Page", field = "tags")
    fun tags(pageDto: PageDto): List<TagDto> {
        return getTagsByPageIdService.execute(pageDto.id!!)
    }
}