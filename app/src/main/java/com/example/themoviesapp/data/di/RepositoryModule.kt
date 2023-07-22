package com.example.themoviesapp.data.di

import com.example.themoviesapp.data.MovieRepositoryImp
import com.example.themoviesapp.data.datasource.MovieCacheDataSource
import com.example.themoviesapp.data.datasource.MovieLocalDataSource
import com.example.themoviesapp.data.datasource.MovieRemoteDataSource
import com.example.themoviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ):MovieRepository{
        return MovieRepositoryImp(movieCacheDataSource,movieLocalDataSource,movieRemoteDataSource)
    }
}