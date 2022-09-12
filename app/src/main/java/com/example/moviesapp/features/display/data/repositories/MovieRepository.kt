package com.example.moviesapp.features.display.data.repositories

import com.example.moviesapp.features.display.data.contracts.MovieRepositoryContract
import com.example.moviesapp.features.display.data.datasources.database.movie.MovieDao
import com.example.moviesapp.features.display.data.mappers.MovieDataMapper
import com.example.moviesapp.features.display.domain.entities.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao
) : MovieRepositoryContract {
    override suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        MovieDataMapper.fromDbToEntities(movieDao.getAll())
    }

    override suspend fun insertMovies(movies: List<Movie>) = withContext(Dispatchers.IO) {
        movieDao.insertMultiple(MovieDataMapper.toDbEntities(movies))
    }
}