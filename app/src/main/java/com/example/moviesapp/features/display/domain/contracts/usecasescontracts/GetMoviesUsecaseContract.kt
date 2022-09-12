package com.example.moviesapp.features.display.domain.contracts.usecasescontracts

import com.example.moviesapp.features.display.domain.entities.Movie

interface GetMoviesUsecaseContract {
    suspend fun get(): List<Movie>
}