package com.example.mykotlinapp.androidWrapper

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.net.ConnectivityManagerCompat

class NetworkManager (private val applicationContext: Context) {
    @Suppress("DEPRECATION")
    val isConnected: Boolean?
    get(){
        val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = conManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }

}