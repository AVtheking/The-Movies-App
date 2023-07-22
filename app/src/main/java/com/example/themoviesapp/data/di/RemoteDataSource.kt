package com.example.themoviesapp.data.di

import com.example.themoviesapp.data.api.TMDBService
import com.example.themoviesapp.data.datasource.MovieRemoteDataSource
import com.example.themoviesapp.data.datasource.TvRemoteDataSource
import com.example.themoviesapp.data.datasourceimplementation.MovieRemoteDataSourceImp
import com.example.themoviesapp.data.datasourceimplementation.TvRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class RemoteDataSource(private val apikey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImp(tmdbService,apikey)
    }
    @Singleton
    @Provides
    fun providesTvRemoteDataSource(tmdbService: TMDBService):TvRemoteDataSource{
        return TvRemoteDataSourceImp(apikey,tmdbService)
    }
}