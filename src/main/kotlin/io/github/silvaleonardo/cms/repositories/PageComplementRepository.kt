package io.github.silvaleonardo.cms.repositories

import io.github.silvaleonardo.cms.entities.PageComplement
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface PageComplementRepository: JpaRepository<PageComplement, Long> {

    fun findByPageId(pageId: Long): Optional<PageComplement>
}