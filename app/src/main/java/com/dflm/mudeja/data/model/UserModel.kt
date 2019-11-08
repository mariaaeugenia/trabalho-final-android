package com.dflm.mudeja.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val name: String,

    val email: String,

    val password: String
)