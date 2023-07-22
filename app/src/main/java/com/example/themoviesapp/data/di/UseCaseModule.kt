package com.example.themoviesapp.data.di

import com.example.themoviesapp.domain.repository.MovieRepository
import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providesGetMovieUseCase(movieRepository: MovieRepository):GetMovieUseCase
    {
        return GetMovieUseCase(movieRepository)
    }
    @Provides
    fun providesUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase
    {
        return UpdateMovieUseCase(movieRepository)
    }
}