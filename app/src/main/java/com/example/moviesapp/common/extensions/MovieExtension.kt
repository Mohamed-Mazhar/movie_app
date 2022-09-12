package com.example.moviesapp.common.extensions

import com.example.moviesapp.features.display.domain.entities.Movie

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

fun Movie.getPosterUrl(): String {
    return "${IMAGE_BASE_URL}w500${this.posterPath}"
}

fun Movie.getBackdropUrl(): String {
    return "${IMAGE_BASE_URL}original${this.backdropPath}"
}