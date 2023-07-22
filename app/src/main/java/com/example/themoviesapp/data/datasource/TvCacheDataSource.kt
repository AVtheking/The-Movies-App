package com.example.themoviesapp.data.datasource

import com.example.themoviesapp.data.model.TV

interface TvCacheDataSource {
    suspend fun getShowsFormCache():List<TV>
    suspend fun saveShowsInCache(tv:List<TV>)
}