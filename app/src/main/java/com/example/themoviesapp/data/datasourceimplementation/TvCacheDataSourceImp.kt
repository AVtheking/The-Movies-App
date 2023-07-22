package com.example.themoviesapp.data.datasourceimplementation

import com.example.themoviesapp.data.datasource.TvCacheDataSource
import com.example.themoviesapp.data.model.TV

class TvCacheDataSourceImp :TvCacheDataSource{
    private var showList=ArrayList<TV>()
    override suspend fun getShowsFormCache(): List<TV> {
        return showList

    }

    override suspend fun saveShowsInCache(tv: List<TV>) {

            showList.clear()
            showList=ArrayList(tv)

    }

}