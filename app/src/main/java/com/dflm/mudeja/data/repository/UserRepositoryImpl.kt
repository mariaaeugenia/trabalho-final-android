package com.dflm.mudeja.data.repository

import com.dflm.mudeja.data.database.UserDao
import com.dflm.mudeja.data.model.UserModel
import com.dflm.mudeja.domain.repository.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(private val userDao: UserDao) :
    UserRepository {
    override fun save(userModel: UserModel) {
        userDao.save(userModel)
    }

    override fun update(userModel: UserModel) {
        userDao.update(userModel)
    }

    override fun delete(userModel: UserModel) {
        userDao.delete(userModel)
    }

    override fun findUser(userModel: UserModel): Single<UserModel> =
        userDao.findUser(userModel.email, userModel.password)
}