package com.dflm.mudeja.data.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.dflm.mudeja.data.model.UserModel
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun save(user: UserModel)

    @Update(onConflict = REPLACE)
    fun update(user: UserModel)

    @Delete
    fun delete(user: UserModel)

    @Query("select * from usermodel where email = :email and password = :password")
    fun findUser(email: String, password: String): Single<UserModel>
}