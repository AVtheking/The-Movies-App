package com.example.themoviesapp.domain.useCases

import com.example.themoviesapp.data.model.TV
import com.example.themoviesapp.domain.repository.TvRepository

class UpdateTvShowsUseCase(private val tvRepository: TvRepository) {
    suspend fun execute():List<TV>?=tvRepository.updateShows()
}