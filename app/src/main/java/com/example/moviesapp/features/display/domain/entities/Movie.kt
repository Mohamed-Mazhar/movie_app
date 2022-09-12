package com.example.moviesapp.features.display.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val genre: Genre,
    val releaseDate: String,
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val originalLanguage: String? = null,
    val popularity: Double? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
    val overview: String? = null,
): Parcelable
