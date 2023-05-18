package io.github.silvaleonardo.cms.resolvers.pages.complements

import graphql.TypeResolutionEnvironment
import graphql.schema.GraphQLObjectType
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementPostDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementReviewDto
import io.github.silvaleonardo.cms.dtos.pages.complements.PageComplementDto
import org.springframework.graphql.execution.ClassNameTypeResolver

class PageComplementUnionTypeResolver: ClassNameTypeResolver() {

    override fun getType(environment: TypeResolutionEnvironment): GraphQLObjectType? =
        when (environment.getObject<PageComplementDto>()::class) {
            PageComplementPostDto::class -> environment.schema.getObjectType("PageComplementPost")
            PageComplementReviewDto::class -> environment.schema.getObjectType("PageComplementReview")
            else -> super.getType(environment)
        }
}