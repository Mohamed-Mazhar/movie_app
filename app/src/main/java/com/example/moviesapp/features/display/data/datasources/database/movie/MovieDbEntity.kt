package com.example.moviesapp.features.display.data.datasources.database.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieDbEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "genre_id")
    val genreId: Int,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "adult")
    val adult: Boolean? = null,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String? = null,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String? = null,
    @ColumnInfo(name = "popularity")
    val popularity: Double? = null,
    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double? = null,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int? = null,
    @ColumnInfo(name = "overview")
    val overview: String? = null
)