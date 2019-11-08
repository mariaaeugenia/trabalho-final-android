package com.dflm.mudeja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dflm.mudeja.Database.UserDataBase
import com.dflm.mudeja.Entity.User

class MainActivity : AppCompatActivity() {

    private var mDb: UserDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDb = UserDataBase.getInstance(this)
        insertUserInDb()
        fetchUsersFromDb()
        fetchUsersFromDb()

    }

    private fun insertUserInDb() {
        var user = User()
        user.name = "Jon Doe"
        user.email = "email@email.com"
        user.password = "123456"
        val task = Runnable { mDb?.userDao()?.insert(user) }
    }

    private fun fetchUsersFromDb() {
        val task = Runnable {
            val users = mDb?.userDao()?.getAll()
        }
    }


}
