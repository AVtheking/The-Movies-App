package com.example.themoviesapp.domain.repository

import com.example.themoviesapp.data.model.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}