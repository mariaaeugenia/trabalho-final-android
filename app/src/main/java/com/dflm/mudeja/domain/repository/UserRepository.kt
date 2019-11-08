package com.dflm.mudeja.domain.repository

import com.dflm.mudeja.data.model.UserModel
import io.reactivex.Single

interface UserRepository {

    fun save(userModel: UserModel)

    fun update(userModel: UserModel)

    fun delete(userModel: UserModel)

    fun findUser(userModel: UserModel): Single<UserModel>
}