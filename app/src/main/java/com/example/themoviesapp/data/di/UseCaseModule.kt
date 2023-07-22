package com.example.themoviesapp.data.di

import com.example.themoviesapp.domain.repository.MovieRepository
import com.example.themoviesapp.domain.repository.TvRepository
import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.GetTvShowsUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateTvShowsUseCase
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
    @Provides
    fun providesGetTvShowUseCase(tvRepository: TvRepository):GetTvShowsUseCase
    {
        return GetTvShowsUseCase(tvRepository)
    }
    @Provides
    fun providesUpdateTvShowUseCase(tvRepository: TvRepository):UpdateTvShowsUseCase
    {
        return UpdateTvShowsUseCase(tvRepository)
    }
}