package com.dflm.mudeja.presenter.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dflm.mudeja.domain.entities.User
import com.dflm.mudeja.domain.usecase.UserUseCase
import com.dflm.mudeja.presenter.user.state.UserState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserViewModel(private val userUseCase: UserUseCase) : ViewModel() {

    private val _userState = MutableLiveData<UserState>()
    private val disposable = CompositeDisposable()
    private var loggeddUser: User? = null

    val userState: LiveData<UserState>
        get() = _userState

    fun save(user: User) {
        userUseCase.saveUser(user = user)
    }

    fun update(user: User) {
        userUseCase.updateUser(user = user)
    }

    fun delete(user: User) {
        userUseCase.deleteUser(user = user)
    }

    fun findUser(user: User) {
        disposable.add(
            userUseCase.findUser(user = user)
                .doOnSubscribe { _userState.value = UserState.ShowLoading }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        loggeddUser = it
                        _userState.postValue(UserState.ShowLoggedUser(it))
                    }, {
                        _userState.postValue(UserState.ShowErro)
                    }
                )
        )
    }

    fun isLoggedUser() = loggeddUser

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}