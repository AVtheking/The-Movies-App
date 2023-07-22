package com.example.themoviesapp.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.GetTvShowsUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateTvShowsUseCase

class MyViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {
    fun getMovies()= liveData {
        val movieList=getMovieUseCase.execute()
        emit(movieList)
    }
    fun updateMovies()= liveData {
        val movieList=updateMovieUseCase.execute()
        emit(movieList)
    }
    fun getTvShows()= liveData {
        val showlist=getTvShowsUseCase.execute()
        emit(showlist)
    }
    fun updateTvShows()= liveData {
        val showlist=updateTvShowsUseCase.execute()
        emit(showlist)
    }
}