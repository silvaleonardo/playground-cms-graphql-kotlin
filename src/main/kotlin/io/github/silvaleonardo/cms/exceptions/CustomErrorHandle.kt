package io.github.silvaleonardo.cms.exceptions

import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import io.github.silvaleonardo.cms.exceptions.business.*
import jakarta.validation.ConstraintViolationException
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.stereotype.Component

@Component
class CustomErrorHandle: DataFetcherExceptionResolverAdapter() {

    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError? =
        when (ex) {
            is NotFoundException -> businessExceptionToGraphQLException(env, ex)
            is UnauthorizedException -> businessExceptionToGraphQLException(env, ex)
            is InvalidInputException -> businessExceptionToGraphQLException(env, ex)
            is ConstraintViolationException -> businessExceptionToGraphQLException(env, constraintViolationExceptionToInvalidInputException(ex))
            else -> super.resolveToSingleError(ex, env)
        }

    private fun businessExceptionToGraphQLException(env: DataFetchingEnvironment, ex: BusinessException): GraphQLError? {
        var extensions: Map<String, Any> = mapOf("code" to ex.code)
        if (ex is InvalidInputException) extensions += ("details" to ex.details)
        return GraphqlErrorBuilder.newError()
            .path(env.getExecutionStepInfo().getPath())
            .location(env.getField().getSourceLocation())
            .errorType(ex.code)
            .message(ex.message)
            .extensions(extensions)
            .build()
    }

    private fun constraintViolationExceptionToInvalidInputException(ex: ConstraintViolationException): InvalidInputException =
        InvalidInputException(ex)
}