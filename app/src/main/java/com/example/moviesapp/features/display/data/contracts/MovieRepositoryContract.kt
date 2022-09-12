package com.example.moviesapp.features.display.data.contracts

import com.example.moviesapp.features.display.domain.entities.Movie

interface MovieRepositoryContract {
    suspend fun getMovies(): List<Movie>

    suspend fun insertMovies(movies: List<Movie>): Unit
}