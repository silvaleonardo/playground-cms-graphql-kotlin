package io.github.silvaleonardo.cms.exceptions

class NotFoundException(message: String? = "Entity not found."): RuntimeException(message) {
}