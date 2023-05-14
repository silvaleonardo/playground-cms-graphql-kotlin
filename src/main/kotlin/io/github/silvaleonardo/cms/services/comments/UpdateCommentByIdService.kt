package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.dtos.comments.UpdateCommentDto
import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UpdateCommentByIdService(private val commentRepository: CommentRepository) {

    fun execute(id: Long, updateCommentDto: UpdateCommentDto): CommentDto {
        val comment = commentRepository.findById(id)
        if (comment.isEmpty()) throw NotFoundException("Comment not found.")
        var commentUpdated = commentRepository.save(Comment(
            id = comment.get().id,
            title = updateCommentDto.title ?: comment.get().title,
            body = updateCommentDto.body ?: comment.get().body,
            status = comment.get().status,
            createdAt = comment.get().createdAt,
            updatedAt = LocalDateTime.now(),
            deletedAt = comment.get().deletedAt,
            userId = comment.get().userId,
            commentId = comment.get().commentId
        ))
        return CommentDto.from(commentUpdated)
    }
}