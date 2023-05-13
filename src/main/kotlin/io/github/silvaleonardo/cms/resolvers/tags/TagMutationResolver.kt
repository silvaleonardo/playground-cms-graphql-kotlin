package io.github.silvaleonardo.cms.resolvers.tags

import io.github.silvaleonardo.cms.dtos.tags.CreateTagDto
import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.dtos.tags.UpdateTagDto
import io.github.silvaleonardo.cms.services.tags.CreateTagService
import io.github.silvaleonardo.cms.services.tags.DeleteTagByIdService
import io.github.silvaleonardo.cms.services.tags.UpdateTagByIdService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class TagMutationResolver(
    private val createTagService: CreateTagService,
    private val updateTagByIdService: UpdateTagByIdService,
    private val deleteTagByIdService: DeleteTagByIdService
) {

    @MutationMapping
    fun createTag(@Argument(name = "input") input: CreateTagDto): TagDto {
        return createTagService.execute(input)
    }

    @MutationMapping
    fun updateTagById(@Argument(name = "id") id: Long, @Argument(name = "input") input: UpdateTagDto): TagDto {
        return updateTagByIdService.execute(id, input)
    }

    @MutationMapping
    fun deleteTagById(@Argument(name = "id") id: Long):Boolean {
        deleteTagByIdService.execute(id)
        return true
    }
}