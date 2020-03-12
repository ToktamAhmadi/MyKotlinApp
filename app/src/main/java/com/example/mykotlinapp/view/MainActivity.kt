package com.example.mykotlinapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.ActivityMainBinding
import com.example.mykotlinapp.view.adapter.NameAdapter
import com.example.mykotlinapp.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NameAdapter

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        adapter = NameAdapter(arrayListOf())

        binding.vm = vm
        binding.mainRvListName.layoutManager = LinearLayoutManager(this)
        binding.mainRvListName.adapter = adapter
        binding.executePendingBindings()

        vm.names.observe(this, Observer {
            if (it != null)
             { adapter.reloadData(it)}
        })
    }


}
