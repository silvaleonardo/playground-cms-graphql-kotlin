package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.entities.Comment
import io.github.silvaleonardo.cms.entities.CommentStatus
import io.github.silvaleonardo.cms.exceptions.business.NotFoundException
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeleteCommentByIdService(private val commentRepository: CommentRepository) {

    fun execute(id: Long) {
        val comment = commentRepository.findById(id)
        if (comment.isEmpty()) throw NotFoundException("Comment not found.")
        commentRepository.save(Comment(
            id = comment.get().id,
            title = comment.get().title,
            body = comment.get().body,
            status = CommentStatus.DELETED,
            createdAt = comment.get().createdAt,
            updatedAt = LocalDateTime.now(),
            deletedAt = LocalDateTime.now(),
            userId = comment.get().userId,
            commentId = comment.get().commentId
        ))
    }
}