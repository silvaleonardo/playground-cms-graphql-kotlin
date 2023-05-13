package io.github.silvaleonardo.cms.resolvers.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.services.comments.GetCommentByIdService
import io.github.silvaleonardo.cms.services.comments.GetCommentsByUserIdService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class CommentQueryResolver(
    private val getCommentsByUserIdService: GetCommentsByUserIdService,
    private val getCommentByIdService: GetCommentByIdService
) {

    @QueryMapping
    fun getCommentsByUserId(@Argument(name = "userId") userId: Long, @Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<CommentDto> {
        return getCommentsByUserIdService.execute(userId, page, size)
    }

    @QueryMapping
    fun getCommentById(@Argument(name = "id") id: Long): CommentDto {
        return getCommentByIdService.execute(id)
    }
}