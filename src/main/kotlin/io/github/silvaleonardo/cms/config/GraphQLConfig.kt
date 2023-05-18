package io.github.silvaleonardo.cms.config

import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.TypeRuntimeWiring
import io.github.silvaleonardo.cms.resolvers.pages.complements.PageComplementUnionTypeResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class GraphQLConfig {

    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer? =
        RuntimeWiringConfigurer { wiringBuilder: RuntimeWiring.Builder ->
            wiringBuilder.type("PageComplement") { builder: TypeRuntimeWiring.Builder -> builder.typeResolver(
                PageComplementUnionTypeResolver()
            ) }
        }
}