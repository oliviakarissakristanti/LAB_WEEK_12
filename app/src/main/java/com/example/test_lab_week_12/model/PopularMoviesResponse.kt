package com.example.test_lab_week_12.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMoviesResponse(
    val page: Int = 0,
    val results: List<Movie> = emptyList()
)
