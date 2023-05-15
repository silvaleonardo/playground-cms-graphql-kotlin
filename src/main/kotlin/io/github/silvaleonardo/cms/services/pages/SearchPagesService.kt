package io.github.silvaleonardo.cms.services.pages

import io.github.silvaleonardo.cms.dtos.pages.PageDto
import io.github.silvaleonardo.cms.dtos.pages.PageSearchDto
import io.github.silvaleonardo.cms.services.tags.GetTagByNameService
import io.github.silvaleonardo.cms.services.users.GetUserByEmailService
import io.github.silvaleonardo.cms.services.users.GetUserByNicknameService
import org.springframework.stereotype.Service

@Service
class SearchPagesService(
    private val getPagesByUserIdService: GetPagesByUserIdService,
    private val getPagesByTagIdService: GetPagesByTagIdService,
    private val getUserByNicknameService: GetUserByNicknameService,
    private val getUserByEmailService: GetUserByEmailService,
    private val getTagByNameService: GetTagByNameService
) {

    fun execute(pageSearchDto: PageSearchDto, page: Int = 1, size: Int = 10): List<PageDto> {
        if (!pageSearchDto.userNickname.isNullOrBlank()) {
            val user = getUserByNicknameService.execute(pageSearchDto.userNickname)
            return getPagesByUserIdService.execute(user.id!!, page, size)
        } else if (!pageSearchDto.userEmail.isNullOrBlank()) {
            val user = getUserByEmailService.execute(pageSearchDto.userEmail)
            return getPagesByUserIdService.execute(user.id!!, page, size)
        } else if (!pageSearchDto.tagName.isNullOrBlank()) {
            var tag = getTagByNameService.execute(pageSearchDto.tagName)
            return getPagesByTagIdService.execute(tag.id!!, page, size)
        }
        return emptyList()
    }
}