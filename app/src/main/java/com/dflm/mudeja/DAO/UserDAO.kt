package com.dflm.mudeja.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dflm.mudeja.Entity.User

@Dao
interface UserDao {

    @Query("SELECT * from users")
    fun getAll(): List<User>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: User)

    @Query("DELETE from users")
    fun deleteAll()
}