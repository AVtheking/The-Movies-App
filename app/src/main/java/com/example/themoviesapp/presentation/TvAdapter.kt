package com.example.themoviesapp.presentation

import android.media.browse.MediaBrowser.ItemCallback
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.data.model.TV
import com.example.themoviesapp.databinding.ShowItemBinding

class TvAdapter():RecyclerView.Adapter<TvAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ShowItemBinding)
        :RecyclerView.ViewHolder(binding.root)



    private var differCallback=object :DiffUtil.ItemCallback<TV>(){
        override fun areItemsTheSame(oldItem: TV, newItem: TV): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: TV, newItem: TV): Boolean {
           return  oldItem==newItem
        }


    }
    val differ=AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(
          ShowItemBinding.inflate(
              LayoutInflater.from(parent.context),parent,false
          )
      )
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentList=differ.currentList[position]
        holder.binding.TvShowName.text=currentList.name
        val posterURl="https://image.tmdb.org/t/p/w500/"+currentList.poster_path

       Glide.with(holder.binding.ShowImage)
           .load(posterURl)
           .into(holder.binding.ShowImage)
    }
}