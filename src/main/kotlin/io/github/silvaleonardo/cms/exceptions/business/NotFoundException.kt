package io.github.silvaleonardo.cms.exceptions.business

import io.github.silvaleonardo.cms.exceptions.BusinessException
import org.springframework.graphql.execution.ErrorType

class NotFoundException(message: String? = "Entity not found."): BusinessException(message, ErrorType.NOT_FOUND) {
}