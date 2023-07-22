package com.example.themoviesapp.data.datasource

import com.example.themoviesapp.data.model.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>

    suspend fun saveMovieToCache(movies:List<Movie>)
}