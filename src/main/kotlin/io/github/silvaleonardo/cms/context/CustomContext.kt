package io.github.silvaleonardo.cms.context

import org.springframework.graphql.server.WebGraphQlInterceptor
import org.springframework.graphql.server.WebGraphQlRequest
import org.springframework.graphql.server.WebGraphQlResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CustomContext: WebGraphQlInterceptor {
    override fun intercept(request: WebGraphQlRequest, chain: WebGraphQlInterceptor.Chain): Mono<WebGraphQlResponse> {
        val headerXUserToken = request.headers.getFirst("x-user-token") ?: ""
        request.configureExecutionInput { executionInput, builder -> builder.graphQLContext { contextBuilder -> contextBuilder.of("userToken", headerXUserToken) }.build() }
        return chain.next(request)
    }
}