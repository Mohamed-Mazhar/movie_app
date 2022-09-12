package com.example.moviesapp.features.display.domain.contracts.servicescontracts

import com.example.moviesapp.features.display.data.datasources.apis.movie.MovieDataModel
import com.example.moviesapp.features.display.domain.entities.Movie
import retrofit2.Response

interface MovieServiceContract {
    suspend fun getMovies(): Response<Movie>
}