package com.example.themoviesapp.data.datasource

import com.example.themoviesapp.data.model.TV

interface TvLocalDataSource {
    suspend fun getMoviesFromDb():List<TV>
    suspend fun saveMoviesToDb(tv:List<TV>)
    suspend fun clearAll()
}