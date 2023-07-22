package com.example.themoviesapp.domain.repository

import com.example.themoviesapp.data.model.TV

interface TvRepository {
    suspend fun getShows():List<TV>?
    suspend fun updateShows():List<TV>?
}