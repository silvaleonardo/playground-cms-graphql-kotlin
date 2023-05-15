package io.github.silvaleonardo.cms.services.comments

import io.github.silvaleonardo.cms.dtos.comments.CommentDto
import io.github.silvaleonardo.cms.repositories.CommentRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetCommentsByPageIdService(private val commentRepository: CommentRepository) {

    fun execute(pageId: Long, page: Int = 1, size: Int = 10): List<CommentDto> {
        val paging = if (page > 0)  (page -1) else 0
        val pageable: Pageable = PageRequest.of(paging, size)
        val comments = commentRepository.findByPageId(pageId, pageable)
        return comments.map { it -> CommentDto.from(it) }.toList()
    }
}