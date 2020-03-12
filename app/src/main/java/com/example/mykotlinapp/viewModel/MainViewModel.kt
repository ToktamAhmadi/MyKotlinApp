package com.example.mykotlinapp.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mykotlinapp.dataSource.NameModel
import com.example.mykotlinapp.extentions.plusAssign
import com.example.mykotlinapp.model.MainModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * implements MainModelCallback
 * so implement it's fun
 */
class MainViewModel(private val model: MainModel): ViewModel(){

    /**
     * this var isLoading is boolean var that
     * control view like progressBar
     * by viewModel
     * and ObservableField is part of DataBinding library
     * that control on data that bind
     */
    var isLoading= ObservableField<Boolean>(false)

    private val compositeDisposable = CompositeDisposable()
    val names= MutableLiveData<ArrayList<NameModel>>()

    //get data from MainModel
   fun loadData(){
        isLoading.set(true)
      compositeDisposable += model.loadData().subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(
              {success: ArrayList<NameModel> ->
                  isLoading.set(false)
                //get data to activity
                  names.value= success
              },
              { error ->
                  Log.e("rx error","loading error")
              }
          )
   }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
        { compositeDisposable.dispose() }
    }

}

/**
 * interface MainViewModelCallback
 * for send data to view
 */
//interface MainViewModelCallback{
//    fun onDataFetched(name: ArrayList<NameModel>)
//}