package com.app.test

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@HiltAndroidApp
class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}