package io.github.silvaleonardo.cms.validators

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass


@Target(FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PageStatusNotDeletedValidator::class])
@MustBeDocumented
annotation class PageStatusNotDeleted (
    val message: String = "unable to use status value DELETED",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)