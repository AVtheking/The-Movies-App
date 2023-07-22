package com.example.themoviesapp.data.di

import com.example.themoviesapp.data.datasource.MovieLocalDataSource
import com.example.themoviesapp.data.datasourceimplementation.MovieLocalDataSourceImp
import com.example.themoviesapp.data.db.MovieDao

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImp(movieDao)
    }
}