package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.datasource.TvLocalDataSource
import com.example.themoviesapp.data.db.TvDao
import com.example.themoviesapp.data.model.TV
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvLocalDataSourceImp(private val tvDao: TvDao): TvLocalDataSource {
    override suspend fun getMoviesFromDb(): List<TV> {
      return  tvDao.getTvShows()
    }

    override suspend fun saveMoviesToDb(tv: List<TV>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShow(tv)
        }
    }

    override suspend fun clearAll() {
       CoroutineScope(Dispatchers.IO).launch {
           tvDao.clearAllShows()
       }
    }

}