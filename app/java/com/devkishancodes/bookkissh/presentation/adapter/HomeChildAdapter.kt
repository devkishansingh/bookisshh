package com.devkishancodes.bookkissh.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devkishancodes.bookkissh.databinding.ItemBookBinding
import com.devkishancodes.bookkissh.domain.models.BooksModel
import com.devkishancodes.bookkissh.domain.utils.loadOnline

class HomeChildAdapter(val list: ArrayList<BooksModel>, val context: Context):RecyclerView.Adapter<HomeChildAdapter.ChildViewHolder>() {
    class ChildViewHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: BooksModel, context: Context){
            binding.apply {
                model.apply {
                    imageView.loadOnline(image)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ItemBookBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount()=list.size
    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val model = list[position]
        holder.bind(model, context)
    }
}