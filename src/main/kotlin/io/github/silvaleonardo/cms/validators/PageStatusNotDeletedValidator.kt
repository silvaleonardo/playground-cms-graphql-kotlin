package io.github.silvaleonardo.cms.validators

import io.github.silvaleonardo.cms.entities.PageStatus
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PageStatusNotDeletedValidator: ConstraintValidator<PageStatusNotDeleted, PageStatus> {
    override fun isValid(value: PageStatus?, context: ConstraintValidatorContext?): Boolean =
        !(value.toString().isNotEmpty() && value == PageStatus.DELETED)
}