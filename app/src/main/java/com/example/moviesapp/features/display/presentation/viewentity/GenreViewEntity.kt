package com.example.moviesapp.features.display.presentation.viewentity

import com.example.moviesapp.features.display.domain.entities.Movie

data class GenreViewEntity(
    val genre: String,
    val movies: List<Movie>
)