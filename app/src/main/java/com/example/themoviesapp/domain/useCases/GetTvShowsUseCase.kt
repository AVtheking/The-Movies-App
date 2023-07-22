package com.example.themoviesapp.domain.useCases

import com.example.themoviesapp.data.model.TV
import com.example.themoviesapp.domain.repository.TvRepository

class GetTvShowsUseCase(private val tvRepository: TvRepository) {
    suspend fun execute():List<TV>?= tvRepository.getShows()
}