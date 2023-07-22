package com.example.themoviesapp.data.api

import com.example.themoviesapp.data.model.MovieList
import com.example.themoviesapp.data.model.TVShows
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey:String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularShows(
        @Query(
            "api_key"
        ) apiKey: String
    ):Response<TVShows>
}