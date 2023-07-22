package com.example.themoviesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.GetTvShowsUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateTvShowsUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMovieUseCase,updateMovieUseCase,getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}