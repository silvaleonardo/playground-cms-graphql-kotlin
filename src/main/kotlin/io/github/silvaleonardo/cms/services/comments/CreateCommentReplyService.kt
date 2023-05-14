package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentReplyDto
import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.stereotype.Service

@Service
class CreateCommentReplyService(private val commentRepository: CommentRepository) {

    fun execute(createCommentReplyDto: CreateCommentReplyDto): CommentDto {
        var comment = Comment.of(createCommentReplyDto)
        comment = commentRepository.save(comment)
        return CommentDto.from(comment)
    }
}