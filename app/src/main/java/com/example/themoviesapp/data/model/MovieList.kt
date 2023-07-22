package com.example.themoviesapp.data.model

import com.example.themoviesapp.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies:List<Movie>
)
