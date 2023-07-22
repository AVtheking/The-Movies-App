package com.example.themoviesapp.data.datasource

import com.example.themoviesapp.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}