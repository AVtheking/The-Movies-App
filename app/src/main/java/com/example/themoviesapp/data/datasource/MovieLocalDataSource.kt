package com.example.themoviesapp.data.datasource

import androidx.lifecycle.LiveData
import com.example.themoviesapp.data.model.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDb():List<Movie>

    suspend fun saveMovetoDb(movies: List<Movie>)

    suspend fun clearAll()


}