package io.github.silvaleonardo.cms.resolvers.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentReplyDto
import io.github.silvaleonardo.cms.dtos.comments.UpdateCommentDto
import io.github.silvaleonardo.cms.services.comments.CreateCommentReplyService
import io.github.silvaleonardo.cms.services.comments.CreateCommentService
import io.github.silvaleonardo.cms.services.comments.DeleteCommentByIdService
import io.github.silvaleonardo.cms.services.comments.UpdateCommentByIdService
import jakarta.validation.Valid
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.ContextValue
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class CommentMutationResolver(
    private val createCommentService: CreateCommentService,
    private val createCommentReplyService: CreateCommentReplyService,
    private val updateCommentByIdService: UpdateCommentByIdService,
    private val deleteCommentByIdService: DeleteCommentByIdService
) {

    @MutationMapping
    fun createComment(@Valid @Argument(name = "input") input: CreateCommentDto, @ContextValue(name = "userToken") userToken: String): CommentDto =
        createCommentService.execute(input, userToken)

    @MutationMapping
    fun createCommentReply(@Valid @Argument(name = "input") input: CreateCommentReplyDto, @ContextValue(name = "userToken") userToken: String): CommentDto =
        createCommentReplyService.execute(input, userToken)

    @MutationMapping
    fun updateCommentById(@Argument(name = "id") id: Long, @Valid @Argument(name = "input") input: UpdateCommentDto): CommentDto =
        updateCommentByIdService.execute(id, input)

    @MutationMapping
    fun deleteCommentById(@Argument(name = "id") id: Long): Boolean {
        deleteCommentByIdService.execute(id)
        return true
    }
}