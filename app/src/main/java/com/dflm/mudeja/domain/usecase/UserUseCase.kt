package com.dflm.mudeja.domain.usecase

import com.dflm.mudeja.data.model.UserModel
import com.dflm.mudeja.domain.entities.User
import com.dflm.mudeja.domain.repository.UserRepository
import com.dflm.mudeja.domain.mapper.toUser
import io.reactivex.Single

class UserUseCase(private val userRepository: UserRepository) {

    fun saveUser(user: User) {
        val userModel = UserModel(
            name = user.name,
            email = user.email,
            password = user.password
        )
        userRepository.save(userModel)
    }

    fun updateUser(user: User) {
        val userModel = UserModel(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password
        )
        userRepository.update(userModel)
    }

    fun deleteUser(user: User) {
        val userModel = UserModel(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password
        )
        userRepository.delete(userModel)
    }

    fun findUser(user: User): Single<User> {
        val userModel = UserModel(
            id = user.id,
            name = user.name,
            email = user.email,
            password = user.password
        )
        return userRepository.findUser(userModel)
            .map { it.toUser() }
    }
}