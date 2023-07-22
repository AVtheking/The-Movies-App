package com.example.themoviesapp.data.di


import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.GetTvShowsUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateTvShowsUseCase
import com.example.themoviesapp.presentation.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase,
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase,updateMovieUseCase,getTvShowsUseCase,updateTvShowsUseCase)
    }
}