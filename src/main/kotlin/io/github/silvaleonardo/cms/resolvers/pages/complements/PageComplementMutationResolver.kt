package io.github.silvaleonardo.cms.resolvers.pages.complements

import io.github.silvaleonardo.cms.dtos.pages.complements.*
import io.github.silvaleonardo.cms.services.pages.complements.CreateComplementPostByPageIdService
import io.github.silvaleonardo.cms.services.pages.complements.CreateComplementReviewByPageIdService
import jakarta.validation.Valid
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class PageComplementMutationResolver(
    private val createComplementPostByPageIdService: CreateComplementPostByPageIdService,
    private val createComplementReviewByPageIdService: CreateComplementReviewByPageIdService
) {

    @MutationMapping
    fun createPageComplementPostByPageId(@Argument(name = "pageId") pageId: Long, @Valid @Argument(name = "input") input: CreatePageComplementPostDto): PageComplementPostDto =
        createComplementPostByPageIdService.execute(pageId, input)

    @MutationMapping
    fun createPageComplementReviewByPageId(@Argument(name = "pageId") pageId: Long, @Valid @Argument(name = "input") input: CreatePageComplementReviewDto): PageComplementReviewDto =
        createComplementReviewByPageIdService.execute(pageId, input)
}