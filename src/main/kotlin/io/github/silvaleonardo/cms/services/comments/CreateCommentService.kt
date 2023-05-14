package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.CreateCommentDto
import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.stereotype.Service

@Service
class CreateCommentService(private val commentRepository: CommentRepository) {

    fun execute(createCommentDto: CreateCommentDto): CommentDto {
        var comment = Comment.of(createCommentDto)
        comment = commentRepository.save(comment)
        return CommentDto.from(comment)
    }
}