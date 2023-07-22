package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.api.TMDBService
import com.example.themoviesapp.data.datasource.MovieRemoteDataSource
import com.example.themoviesapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey:String
):MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)

}