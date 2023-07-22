package com.example.themoviesapp.data.datasource

import com.example.themoviesapp.data.model.TVShows
import retrofit2.Response

interface TvRemoteDataSource {
    suspend fun getMoviesFromRemote():Response<TVShows>
}