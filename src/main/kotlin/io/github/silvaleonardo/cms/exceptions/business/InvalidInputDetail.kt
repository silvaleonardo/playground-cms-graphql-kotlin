package io.github.silvaleonardo.cms.exceptions.business

import jakarta.validation.ConstraintViolation

data class InvalidInputDetail(
    val path: String,
    val message: String
) {
    companion object {
        fun from(constraintViolation: ConstraintViolation<*>): InvalidInputDetail =
            InvalidInputDetail(
                path = constraintViolation.propertyPath.toString(),
                message = constraintViolation.message
            )
    }
}
