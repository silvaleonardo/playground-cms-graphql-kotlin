package io.github.silvaleonardo.cms.exceptions.business

import io.github.silvaleonardo.cms.exceptions.BusinessException
import jakarta.validation.ConstraintViolationException
import org.springframework.graphql.execution.ErrorType

class InvalidInputException(): BusinessException("Input validation error, see extensions.details property for more information.", ErrorType.BAD_REQUEST) {
    var details: List<InvalidInputDetail> = listOf()

    constructor(path: String, message: String): this(InvalidInputDetail(path = path, message = message))

    constructor(invalidInputDetail: InvalidInputDetail): this() {
        this.details = listOf(invalidInputDetail)
    }

    constructor(ex: ConstraintViolationException): this() {
        if (ex.constraintViolations.isNotEmpty()) {
            val details = ex.constraintViolations
                .mapIndexed { _, violation -> InvalidInputDetail.from(violation) }
            this.details = details
        }
    }
}
