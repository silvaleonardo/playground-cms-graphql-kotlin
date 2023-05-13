package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.stereotype.Service

@Service
class GetCommentByIdService(private val commentRepository: CommentRepository) {

    fun execute(id: Long): CommentDto {
        val comment = commentRepository.findById(id)
        if (comment.isEmpty()) throw  NotFoundException("Comment not found.")
        return CommentDto.from(comment.get())
    }
}