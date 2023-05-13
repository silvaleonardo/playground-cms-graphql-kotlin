package io.github.silvaleonardo.cms.resolvers

import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class HealthResolver {

    @QueryMapping(name = "_")
    fun query(): Boolean = true

    @MutationMapping(name = "_")
    fun mutation(): Boolean = true
}