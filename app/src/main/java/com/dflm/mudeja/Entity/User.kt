package com.dflm.mudeja.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "name") var name: String,
                @ColumnInfo(name = "email") var email: String,
                @ColumnInfo(name = "password") var password: String

){
    constructor():this(null,
        "","","")
}