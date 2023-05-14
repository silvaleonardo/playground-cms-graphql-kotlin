package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentDto
import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.exceptions.UnauthorizedException
import io.github.silvaleonardo.cms.repositories.CommentRepository
import io.github.silvaleonardo.cms.services.users.GetUserByTokenService
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CreateCommentService(
    private val commentRepository: CommentRepository,
    private val getUserByTokenService: GetUserByTokenService
) {

    fun execute(createCommentDto: CreateCommentDto, userToken: String): CommentDto {
        val user = try { getUserByTokenService.execute(userToken) } catch (e: Exception) { throw UnauthorizedException() }
        var comment = Comment.of(createCommentDto, user.id!!)
        comment = commentRepository.save(comment)
        return CommentDto.from(comment)
    }
}