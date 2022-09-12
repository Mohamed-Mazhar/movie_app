package com.example.moviesapp.features.display.data.contracts

import com.example.moviesapp.features.display.domain.entities.Movie

interface MovieServiceContract {
    suspend fun getMovies(): List<Movie>
}