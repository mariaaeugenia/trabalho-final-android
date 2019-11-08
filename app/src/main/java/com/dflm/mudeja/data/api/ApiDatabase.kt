package com.dflm.mudeja.data.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dflm.mudeja.data.database.UserDao
import com.dflm.mudeja.data.model.UserModel

@Database(entities = [UserModel::class], version = 1, exportSchema = false)
abstract class ApiDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: ApiDatabase? = null

        fun newInstance(context: Context): ApiDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDataBase(context = context).also { INSTANCE = it }
            }

        @JvmStatic
        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ApiDatabase::class.java,
                "sge_mudeja"
            ).build()
    }
}