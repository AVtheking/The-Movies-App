package com.example.themoviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themoviesapp.data.model.TV

@Dao
interface TvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tv: TV)

    @Query("select *from popular_tv_show")
    suspend fun getTvShows():List<TV>

    @Query("DELETE FROM popular_tv_show")
    suspend fun clearAllShows()
}