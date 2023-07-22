package com.example.themoviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.data.model.TV

@Database(entities = [Movie::class, TV::class], exportSchema = false, version = 3)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao():MovieDao
    abstract fun tvDao():TvDao
}