package com.example.mykotlinapp.androidWrapper

import android.app.Application
import com.example.mykotlinapp.dependencyInjection.viewModleModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(viewModleModule))
    }
}