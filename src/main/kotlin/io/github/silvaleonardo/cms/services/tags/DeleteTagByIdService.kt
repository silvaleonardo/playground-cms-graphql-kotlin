package io.github.silvaleonardo.cms.services.tags

import io.github.silvaleonardo.cms.exceptions.NotFoundException
import io.github.silvaleonardo.cms.repositories.TagRepository
import org.springframework.stereotype.Service

@Service
class DeleteTagByIdService(private val tagRepository: TagRepository) {

    fun execute(id: Long) {
        val tag = tagRepository.findById(id)
        if (tag.isEmpty()) throw NotFoundException("Tag not found.")
        tagRepository.delete(tag.get())
    }
}