package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.datasource.MovieCacheDataSource
import com.example.themoviesapp.data.model.Movie

class MovieCacheDataSouceImp:MovieCacheDataSource {
    private var moviesList=ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
       return moviesList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList= ArrayList(movies)
    }


}