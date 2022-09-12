package com.example.moviesapp.features.display.domain.usecases

import android.util.Log
import com.example.moviesapp.features.display.data.contracts.MovieRepositoryContract
import com.example.moviesapp.features.display.data.contracts.MovieServiceContract
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetMoviesUsecaseContract
import com.example.moviesapp.features.display.domain.entities.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetMoviesUsecase @Inject constructor(
    private val movieService: MovieServiceContract,
    private val movieRepository: MovieRepositoryContract,
) : GetMoviesUsecaseContract {

    override suspend fun get(): List<Movie> = withContext(Dispatchers.Default) {
        val cachedMovies = movieRepository.getMovies()
        Log.d("MovieApp", "Cached data ${cachedMovies.size}")
        cachedMovies.ifEmpty {
            val remoteMovies = movieService.getMovies()
            movieRepository.insertMovies(remoteMovies)
            remoteMovies
        }
    }
}