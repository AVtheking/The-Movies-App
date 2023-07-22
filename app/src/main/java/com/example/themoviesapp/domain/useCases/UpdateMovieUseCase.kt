package com.example.themoviesapp.domain.useCases

import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>?=movieRepository.updateMovies()
}