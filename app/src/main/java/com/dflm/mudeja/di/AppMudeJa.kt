package com.dflm.mudeja.di

import android.app.Application

class AppMudeJa : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}