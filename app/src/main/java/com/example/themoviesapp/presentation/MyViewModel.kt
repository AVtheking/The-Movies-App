package com.example.themoviesapp.presentation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.themoviesapp.domain.useCases.GetMovieUseCase
import com.example.themoviesapp.domain.useCases.UpdateMovieUseCase

class MyViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModel() {
    fun getMovies()= liveData {
        val movieList=getMovieUseCase.execute()
        emit(movieList)
    }
    fun updateMovies()= liveData {
        val movieList=updateMovieUseCase.execute()
        emit(movieList)
    }
}