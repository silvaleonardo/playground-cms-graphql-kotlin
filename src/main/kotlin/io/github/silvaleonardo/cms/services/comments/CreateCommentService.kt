package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentDto
import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.entities.PageComment
import io.github.silvaleonardo.cms.entities.PageCommentCompositePrimaryKey
import io.github.silvaleonardo.cms.exceptions.business.UnauthorizedException
import io.github.silvaleonardo.cms.repositories.CommentRepository
import io.github.silvaleonardo.cms.repositories.PageCommentRepository
import io.github.silvaleonardo.cms.services.pages.GetPageByIdService
import io.github.silvaleonardo.cms.services.users.GetUserByTokenService
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CreateCommentService(
    private val commentRepository: CommentRepository,
    private val pageCommentRepository: PageCommentRepository,
    private val getUserByTokenService: GetUserByTokenService,
    private val getPageByIdService: GetPageByIdService
) {

    fun execute(createCommentDto: CreateCommentDto, userToken: String): CommentDto {
        val user = try { getUserByTokenService.execute(userToken) } catch (e: Exception) { throw UnauthorizedException() }
        val page = getPageByIdService.execute(createCommentDto.pageId)
        var comment = Comment.of(createCommentDto, user.id!!)
        comment = commentRepository.save(comment)
        pageCommentRepository.save(PageComment(
            id = PageCommentCompositePrimaryKey(
                pageId = page.id!!,
                commentId = comment.id!!
            )
        ))
        return CommentDto.from(comment)
    }
}