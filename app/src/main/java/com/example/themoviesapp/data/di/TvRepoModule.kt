package com.example.themoviesapp.data.di

import com.example.themoviesapp.data.TvRepositoryImp
import com.example.themoviesapp.data.datasource.TvCacheDataSource
import com.example.themoviesapp.data.datasource.TvLocalDataSource
import com.example.themoviesapp.data.datasource.TvRemoteDataSource
import com.example.themoviesapp.domain.repository.TvRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class TvRepoModule {
    @Singleton
    @Provides
    fun providesTvRepository(
        tvCacheDataSource: TvCacheDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvRemoteDataSource: TvRemoteDataSource
    ):TvRepository
    {
        return TvRepositoryImp(tvCacheDataSource,tvLocalDataSource,tvRemoteDataSource)
    }
}