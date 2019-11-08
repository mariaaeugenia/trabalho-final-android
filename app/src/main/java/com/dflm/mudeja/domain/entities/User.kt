package com.dflm.mudeja.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String
) : Parcelable