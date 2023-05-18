package io.github.silvaleonardo.cms.utils

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.AttributeConverter

class HashMapConverter: AttributeConverter<Map<String?, Any?>?, String?> {
    private val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: Map<String?, Any?>?): String? =
        objectMapper.writeValueAsString(attribute)

    override fun convertToEntityAttribute(dbData: String?): Map<String?, Any?>? =
        objectMapper.readValue(dbData, object : TypeReference<HashMap<String?, Any?>?>() {})
}