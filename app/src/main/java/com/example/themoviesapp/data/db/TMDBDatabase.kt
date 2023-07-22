package com.example.themoviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themoviesapp.data.model.Movie

@Database(entities = [Movie::class], exportSchema = false, version = 1)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao():MovieDao
    abstract fun tvDao():TvDao
}