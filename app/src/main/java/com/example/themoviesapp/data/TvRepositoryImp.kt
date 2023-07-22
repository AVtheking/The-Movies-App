package com.example.themoviesapp.data

import com.example.themoviesapp.data.datasource.TvCacheDataSource
import com.example.themoviesapp.data.datasource.TvLocalDataSource
import com.example.themoviesapp.data.datasource.TvRemoteDataSource
import com.example.themoviesapp.data.model.Movie
import com.example.themoviesapp.data.model.TV

import com.example.themoviesapp.domain.repository.TvRepository


class TvRepositoryImp(
    private val tvCacheDataSource: TvCacheDataSource,
    private val tvLocalDataSource: TvLocalDataSource,
    private val tvRemoteDataSource: TvRemoteDataSource
):TvRepository {
    override suspend fun getShows(): List<TV>? {
        return getShowsFromCache()

    }

    suspend fun getShowsFromCache(): List<TV>? {
        var tvlist: List<TV> = emptyList()
      try {
          tvlist=tvCacheDataSource.getShowsFormCache()

      }catch (exception:Exception){}
        if(tvlist.size>0)
            return tvlist
        else{
            tvlist=getShowsFromRoom()
            tvCacheDataSource.saveShowsInCache(tvlist)
        }
        return tvlist

    }

    override suspend fun updateShows(): List<TV>? {
        val newlist=getShowsFromAPI()
        tvLocalDataSource.clearAll()
        tvLocalDataSource.saveMoviesToDb(newlist)
        return newlist
    }

    suspend fun getShowsFromAPI():List<TV> {
        var tvlist: List<TV> = emptyList()
        try {
            val response=tvRemoteDataSource.getMoviesFromRemote()
            var body=response.body()
            if(body!=null){
                tvlist=body.shows
            }

        }catch (exception:Exception){}
       return tvlist
    }
    suspend fun getShowsFromRoom():List<TV>{
        var tvlist: List<TV> = emptyList()
        try{
            tvlist=tvLocalDataSource.getMoviesFromDb()

        }catch (exception:Exception){}
        if (tvlist.size>0)
            return tvlist
        else
        {
            tvlist=getShowsFromAPI()
            tvLocalDataSource.saveMoviesToDb(tvlist)
        }
        return tvlist
    }
}