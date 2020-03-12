package com.example.mykotlinapp.dependencyInjection

import androidx.lifecycle.ViewModel
import com.example.mykotlinapp.androidWrapper.NetworkManager
import com.example.mykotlinapp.model.MainModel
import com.example.mykotlinapp.viewModel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val viewModleModule:Module= module {
    viewModel { MainViewModel(get() as MainModel )  }

      single { NetworkManager(androidContext())}
      single { MainModel(get() as NetworkManager) }

}