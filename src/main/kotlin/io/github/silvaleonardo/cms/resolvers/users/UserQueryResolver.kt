package io.github.silvaleonardo.cms.resolvers.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.services.users.GetUserByIdService
import io.github.silvaleonardo.cms.services.users.GetUserByNicknameService
import io.github.silvaleonardo.cms.services.users.GetUsersService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserQueryResolver(
    private val getUsersService: GetUsersService,
    private val getUserByIdService: GetUserByIdService,
    private val getUserByNicknameService: GetUserByNicknameService
) {

    @QueryMapping
    fun getUsers(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<UserDto> {
        return getUsersService.execute(page, size)
    }

    @QueryMapping
    fun getUserById(@Argument(name = "id") id: Long): UserDto {
        return getUserByIdService.execute(id)
    }

    @QueryMapping
    fun getUserByNickname(@Argument(name = "nickname") nickname: String): UserDto {
        return getUserByNicknameService.execute(nickname)
    }
}