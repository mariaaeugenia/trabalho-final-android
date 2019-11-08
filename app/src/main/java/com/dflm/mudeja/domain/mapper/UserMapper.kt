package com.dflm.mudeja.domain.mapper

import com.dflm.mudeja.data.model.UserModel
import com.dflm.mudeja.domain.entities.User

fun UserModel.toUser() =
    User(
        id = id,
        name = name,
        email = email,
        password = password
    )