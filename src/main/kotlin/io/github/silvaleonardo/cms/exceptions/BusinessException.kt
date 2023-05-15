package io.github.silvaleonardo.cms.exceptions

import org.springframework.graphql.execution.ErrorType

open class BusinessException(message: String? = "Business error, please contact the administrator.", errorType: ErrorType?): RuntimeException(message) {
    var code: ErrorType

    init {
        this.code = errorType ?: ErrorType.INTERNAL_ERROR
    }
}