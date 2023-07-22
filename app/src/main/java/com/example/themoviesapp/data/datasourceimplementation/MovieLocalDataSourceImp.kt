package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.datasource.MovieLocalDataSource
import com.example.themoviesapp.data.db.MovieDao
import com.example.themoviesapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImp(private val movieDao: MovieDao):MovieLocalDataSource {
    override suspend fun getMovieFromDb(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMovetoDb(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.DeleteAllMovies()
       }
    }
}