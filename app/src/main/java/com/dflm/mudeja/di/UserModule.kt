package com.dflm.mudeja.di

import android.app.Application
import com.dflm.mudeja.data.api.ApiDatabase
import com.dflm.mudeja.data.repository.UserRepositoryImpl
import com.dflm.mudeja.domain.repository.UserRepository
import com.dflm.mudeja.domain.usecase.UserUseCase
import com.dflm.mudeja.presenter.user.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(userModule))
    }
}

val userModule = module(override = true) {
    single { ApiDatabase.newInstance(androidApplication()).userDao() }
    factory<UserRepository> { UserRepositoryImpl(get()) }
    factory { UserUseCase(get()) }
    viewModel { UserViewModel(get()) }
}
