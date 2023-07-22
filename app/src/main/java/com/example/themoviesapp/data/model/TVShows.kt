package com.example.themoviesapp.data.model

import com.google.gson.annotations.SerializedName

data class TVShows(
    @SerializedName("results")
    val shows: List<TV>

)