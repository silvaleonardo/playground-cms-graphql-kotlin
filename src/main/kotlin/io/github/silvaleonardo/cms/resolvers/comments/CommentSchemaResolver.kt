package io.github.silvaleonardo.cms.resolvers.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.services.comments.GetCommentRepliesByIdService
import io.github.silvaleonardo.cms.services.users.GetUserByIdService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class CommentSchemaResolver(
    private val getCommentRepliesByIdService: GetCommentRepliesByIdService,
    private val getUserByIdService: GetUserByIdService
) {

    @SchemaMapping(typeName = "Comment", field = "replies")
    fun replies(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int, commentDto: CommentDto): List<CommentDto> =
        getCommentRepliesByIdService.execute(commentDto.id!!, page, size)

    @SchemaMapping(typeName = "Comment", field = "user")
    fun user(commentDto: CommentDto): UserDto =
        getUserByIdService.execute(commentDto.userId)
}