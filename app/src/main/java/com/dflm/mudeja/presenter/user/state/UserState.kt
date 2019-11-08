package com.dflm.mudeja.presenter.user.state

import android.os.Parcelable
import com.dflm.mudeja.domain.entities.User
import kotlinx.android.parcel.Parcelize

sealed class UserState {
    @Parcelize
    data class ShowLoggedUser(val user: User) : UserState(), Parcelable

    object ShowErro : UserState()
    object ShowLoading : UserState()
    object HideLoading : UserState()
}