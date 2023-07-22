package com.example.themoviesapp.data.di

import com.example.themoviesapp.data.datasource.MovieCacheDataSource
import com.example.themoviesapp.data.datasourceimplementation.MovieCacheDataSouceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSouceImp()
    }
}