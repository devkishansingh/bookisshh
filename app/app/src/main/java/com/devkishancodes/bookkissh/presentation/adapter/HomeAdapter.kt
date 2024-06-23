package com.devkishancodes.bookkissh.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devkishancodes.bookkissh.databinding.ItemBodBinding
import com.devkishancodes.bookkissh.databinding.ItemHomeBinding
import com.devkishancodes.bookkissh.domain.models.BooksModel
import com.devkishancodes.bookkissh.domain.models.HomeModel
import com.devkishancodes.bookkissh.domain.utils.loadOnline

const val LAYOUT_HOME=0
const val LAYOUT_BOD=1
class HomeAdapter(val list: ArrayList<HomeModel>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
       val mViewPool = RecyclerView.RecycledViewPool()
        class BODItemViewHolder(val binding: ItemBodBinding):RecyclerView.ViewHolder(binding.root)
        {
            fun bind(model: HomeModel, context: Context){
                binding.apply {
                    model.bod?.apply {
                        imageView.loadOnline(image)
                        mReadBookBtn.setOnClickListener{

                        }
                    }
                }
            }
        }
    class HomeItemViewHolder(val binding: ItemHomeBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(model: HomeModel, context: android.content.Context){

            binding.apply {
                model.apply {
                   mCategoryTitle.text= catTitle
                    mSeeAllBtn.setOnClickListener{
                        if (booksList != null) {
                            mChildRvBooks.setupChildRv(booksList,context)
                        }
                    }
                }
            }
        }
        private fun RecyclerView.setupChildRv(list:ArrayList<BooksModel>, context: android.content.Context){
            val adapter= HomeChildAdapter(list,context)
            this.adapter=adapter
            val mViewPool = RecyclerView.RecycledViewPool()
            setRecycledViewPool(mViewPool)
        }
    }
    override fun getItemViewType(position: Int):Int{
        val model=list[position]
        return when(model.LAYOUT_TYPE)
        {
            LAYOUT_HOME -> LAYOUT_HOME
            else-> LAYOUT_BOD
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
        LAYOUT_HOME ->{
            HomeItemViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(context),parent,false))
        }
       else->{
           BODItemViewHolder(ItemBodBinding.inflate(LayoutInflater.from(context),parent,false))

       }
    }
 }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
             val model=list[position]
            when(model.LAYOUT_TYPE) {
            LAYOUT_HOME ->{
                LAYOUT_HOME
            }
            else-> LAYOUT_BOD
        }
    }
}