package io.github.silvaleonardo.cms.exceptions.business

import io.github.silvaleonardo.cms.exceptions.BusinessException
import org.springframework.graphql.execution.ErrorType

class UnauthorizedException(message: String? = "Unauthorized access."): BusinessException(message, ErrorType.UNAUTHORIZED) {
}