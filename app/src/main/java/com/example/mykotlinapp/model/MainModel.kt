package com.example.mykotlinapp.model


import com.example.mykotlinapp.androidWrapper.NetworkManager
import com.example.mykotlinapp.dataSource.NameModel
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MainModel(private val networkManager: NetworkManager) {
    /**
     * create model as array list
     * used data than make here not from server
     * fun loadData has parameter as interface MainModelCallback
     * that when ready data send viewModel
     */
    fun loadData() :Observable<ArrayList<NameModel>> {
        val onlineList = ArrayList<NameModel>()
        onlineList.add(NameModel("Toktam Ahmadi is  online"))
        onlineList.add(NameModel("Reza Ahmadi is  online"))
        onlineList.add(NameModel("Nader Abdollahi is  online"))
        onlineList.add(NameModel("Zahra Rezaei is  online"))

        val offlineList = ArrayList<NameModel>()
        offlineList.add(NameModel("Toktam Ahmadi is  offline"))
        offlineList.add(NameModel("Reza Ahmadi is offline"))
        offlineList.add(NameModel("Nader Abdollahi is offline"))
        offlineList.add(NameModel("Zahra Rezaei is offline"))

        if (networkManager.isConnected !!){
            return Observable.just(onlineList).delay(1,TimeUnit.SECONDS)
        }
        else
        {
            return Observable.just(offlineList).delay (1,TimeUnit.SECONDS)
        }

    }
}
/**
 * for transfer data from model(here)
 * to viewModel
 * so need a fun that send data as array NameModel
 * to viewModel
 */
//interface MainModelCallback{
//    fun onDataFetched(name: ArrayList<NameModel>)
//}
