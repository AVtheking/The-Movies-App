package com.example.themoviesapp.data.di


import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import com.example.themoviesapp.presentation.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase,updateMovieUseCase)
    }
}