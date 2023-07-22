package com.example.themoviesapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.themoviesapp.data.db.MovieDao
import com.example.themoviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context):TMDBDatabase{
        return Room.databaseBuilder(context,
        TMDBDatabase::class.java,
        "tmdbclient").build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
}