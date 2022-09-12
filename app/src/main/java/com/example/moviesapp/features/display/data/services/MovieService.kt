package com.example.moviesapp.features.display.data.services

import com.example.moviesapp.features.display.data.contracts.MovieServiceContract
import com.example.moviesapp.features.display.data.datasources.apis.movie.MovieApi
import com.example.moviesapp.features.display.data.mappers.MovieDataMapper
import com.example.moviesapp.features.display.domain.entities.Movie
import javax.inject.Inject

class MovieService @Inject constructor(
    private val movieApi: MovieApi
) : MovieServiceContract {

    override suspend fun getMovies(): List<Movie> {
        val response = movieApi.getMovies()
        return if (response.isSuccessful) {
            response.body()?.let {
                MovieDataMapper.toEntities(movieDataModels = it.movies)
            } ?: listOf()
        } else {
            listOf()
        }
    }

}