package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.api.TMDBService
import com.example.themoviesapp.data.datasource.TvRemoteDataSource
import com.example.themoviesapp.data.model.TVShows
import retrofit2.Response

class TvRemoteDataSourceImp(
    private val apikey:String,
    private val tmdbService: TMDBService
):TvRemoteDataSource {
    override suspend fun getMoviesFromRemote(): Response<TVShows> =
        tmdbService.getPopularShows(apikey)


}