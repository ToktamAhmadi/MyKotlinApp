package com.example.mykotlinapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykotlinapp.dataSource.NameModel
import com.example.mykotlinapp.databinding.RowItemBinding

class NameAdapter (private var names:ArrayList<NameModel>) :RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater= LayoutInflater.from(parent.context)
        val binding: RowItemBinding= RowItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(names[position])

      class ViewHolder(private var binding: RowItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(nameModel: NameModel)
        {
            binding.model= nameModel
            binding.executePendingBindings()

        }
    }

    fun reloadData(list: ArrayList<NameModel>){
        names = list
        notifyDataSetChanged()
    }
}