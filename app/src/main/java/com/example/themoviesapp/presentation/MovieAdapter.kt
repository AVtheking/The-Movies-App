package com.example.themoviesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.databinding.ListItemBinding

class MovieAdapter ():RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

       private var differCallback=object:ItemCallback<Movie>(){
           override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
               return oldItem.id==newItem.id &&
                      oldItem.title==newItem.title
           }

           override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                 return oldItem==newItem
           }

       }
    val differ=AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(
         ListItemBinding.inflate(
             LayoutInflater.from(parent.context),parent,false
         )
       )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
    class MyViewHolder(var binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root)
    {
           fun bind(movie:Movie)
           {
               binding.movietitle.text=movie.title
//               binding.movieDescription.text=movie.overview

               val posterURL="https://image.tmdb.org/t/p/w500/"+movie.posterPath
               Glide.with(binding.imageview.context)
                   .load(posterURL)
                   .into(binding.imageview)
           }
    }


}