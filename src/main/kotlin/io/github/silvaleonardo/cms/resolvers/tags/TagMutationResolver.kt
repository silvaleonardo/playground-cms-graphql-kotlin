package io.github.silvaleonardo.cms.resolvers.tags

import io.github.silvaleonardo.cms.dtos.tags.CreateTagDto
import io.github.silvaleonardo.cms.dtos.tags.TagDto
import io.github.silvaleonardo.cms.dtos.tags.UpdateTagDto
import io.github.silvaleonardo.cms.services.tags.CreateTagService
import io.github.silvaleonardo.cms.services.tags.DeleteTagByIdService
import io.github.silvaleonardo.cms.services.tags.UpdateTagByIdService
import jakarta.validation.Valid
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
    fun createTag(@Valid @Argument(name = "input") input: CreateTagDto): TagDto =
        createTagService.execute(input)

    @MutationMapping
    fun updateTagById(@Argument(name = "id") id: Long, @Valid @Argument(name = "input") input: UpdateTagDto): TagDto =
        updateTagByIdService.execute(id, input)

    @MutationMapping
    fun deleteTagById(@Argument(name = "id") id: Long):Boolean {
        deleteTagByIdService.execute(id)
        return true
    }
}