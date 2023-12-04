package com.example.tvshowapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tvshowapp2.R
import com.example.tvshowapp2.databinding.TvShowLayoutAdapterBinding
import com.example.tvshowapp2.model.tvshowmodelItem

class tvshowadapter: RecyclerView.Adapter<tvshowadapter.Myviewholder>() {

    inner class Myviewholder(val binding: TvShowLayoutAdapterBinding): RecyclerView.ViewHolder(binding.root)
    private val diffcallback=object : DiffUtil.ItemCallback<tvshowmodelItem>(){
        override fun areItemsTheSame(oldItem: tvshowmodelItem, newItem: tvshowmodelItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: tvshowmodelItem, newItem: tvshowmodelItem): Boolean {
            return newItem== oldItem
        }

    }
    private val differ= AsyncListDiffer(this,diffcallback)
    var tvshow:List<tvshowmodelItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        return Myviewholder(TvShowLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return tvshow.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currenttvshow=tvshow[position]


            holder.binding.textView2.text=currenttvshow.name
    if(currenttvshow.image!=null) {
    Glide.with(holder.itemView.context).load(currenttvshow.image)
        .into(holder.binding.imageview);
       }

    }
}