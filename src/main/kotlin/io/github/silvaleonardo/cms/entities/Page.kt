package io.github.silvaleonardo.cms.entities

import io.github.silvaleonardo.cms.dtos.pages.CreatePageDto
import io.github.silvaleonardo.cms.dtos.pages.UpdatePageDto
import jakarta.persistence.*
import org.hibernate.annotations.ColumnTransformer
import java.time.LocalDateTime

@Entity
@Table(name = "pages")
data class Page(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    val summary: String?,
    val body: String?,
    @ColumnTransformer(read = "UPPER(status)", write = "LOWER(?)")
    @Enumerated(EnumType.STRING)
    val status: PageStatus,
    @Column(name = "created_at")
    val createdAt: LocalDateTime,
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
    @Column(name = "deleted_at")
    val deletedAt: LocalDateTime?,
    @Column(name = "user_id")
    val userId: Long
) {
    companion object {
        fun of(createPageDto: CreatePageDto, userId: Long): Page =
            Page(
                id = null,
                title =  createPageDto.title,
                summary = createPageDto.summary ?: null,
                body = createPageDto.body ?: null,
                status = createPageDto.status ?: PageStatus.DRAFT,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
                deletedAt = null,
                userId = userId
            )
    }
}
