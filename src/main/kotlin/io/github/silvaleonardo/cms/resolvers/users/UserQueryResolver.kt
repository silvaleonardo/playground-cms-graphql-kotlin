package io.github.silvaleonardo.cms.resolvers.users

import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.services.users.GetUserByIdService
import io.github.silvaleonardo.cms.services.users.GetUserByNicknameService
import io.github.silvaleonardo.cms.services.users.GetUserTokenService
import io.github.silvaleonardo.cms.services.users.GetUsersService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserQueryResolver(
    private val getUsersService: GetUsersService,
    private val getUserByIdService: GetUserByIdService,
    private val getUserByNicknameService: GetUserByNicknameService,
    private val getUserTokenService: GetUserTokenService
) {

    @QueryMapping
    fun getUsers(@Argument(name = "page") page: Int, @Argument(name = "size") size: Int): List<UserDto> =
        getUsersService.execute(page, size)

    @QueryMapping
    fun getUserById(@Argument(name = "id") id: Long): UserDto =
        getUserByIdService.execute(id)

    @QueryMapping
    fun getUserByNickname(@Argument(name = "nickname") nickname: String): UserDto =
        getUserByNicknameService.execute(nickname)

    @QueryMapping
    fun getUserToken(@Argument(name = "nickname") nickname: String, @Argument(name = "email") email: String): String =
        getUserTokenService.execute(nickname, email)
}