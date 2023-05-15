package io.github.silvaleonardo.cms.resolvers.users

import io.github.silvaleonardo.cms.dtos.users.CreateUserDto
import io.github.silvaleonardo.cms.dtos.users.UpdateUserDto
import io.github.silvaleonardo.cms.dtos.users.UserDto
import io.github.silvaleonardo.cms.services.users.CreateUserService
import io.github.silvaleonardo.cms.services.users.DeleteUserByIdService
import io.github.silvaleonardo.cms.services.users.UpdateUserByIdService
import jakarta.validation.Valid
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class UserMutationResolver(
    private val createUserService: CreateUserService,
    private val updateUserByIdService: UpdateUserByIdService,
    private val deleteUserByIdService: DeleteUserByIdService
) {

    @MutationMapping
    fun createUser(@Valid @Argument(name = "input") input: CreateUserDto): UserDto {
        return createUserService.execute(input)
    }

    @MutationMapping
    fun updateUserById(@Argument(name = "id") id: Long, @Valid @Argument(name = "input") input: UpdateUserDto): UserDto {
        return updateUserByIdService.execute(id, input)
    }

    @MutationMapping
    fun deleteUserById(@Argument(name = "id") id: Long): Boolean {
        deleteUserByIdService.execute(id)
        return true
    }
}