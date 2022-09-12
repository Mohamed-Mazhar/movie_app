package com.example.moviesapp.features.display.data.mappers

import com.example.moviesapp.features.display.data.datasources.cached.GenreDataSource
import com.example.moviesapp.features.display.data.datasources.apis.movie.MovieDataModel
import com.example.moviesapp.features.display.data.datasources.database.movie.MovieDbEntity
import com.example.moviesapp.features.display.domain.entities.Movie


object MovieDataMapper {

    fun toEntities(movieDataModels: List<MovieDataModel>): List<Movie> {
        return movieDataModels.map {
            toEntity(movieDataModel = it)
        }
    }

    private fun toEntity(movieDataModel: MovieDataModel) = Movie(
        id = movieDataModel.id,
        title = movieDataModel.title,
        releaseDate = movieDataModel.releaseDate,
        genre = GenreDataSource.getGenreById(movieDataModel.genreIds.first()),
        adult = movieDataModel.adult,
        backdropPath = movieDataModel.backdropPath,
        originalLanguage = movieDataModel.originalLanguage,
        popularity = movieDataModel.popularity,
        posterPath = movieDataModel.posterPath,
        voteAverage = movieDataModel.voteAverage,
        voteCount = movieDataModel.voteCount,
        overview = movieDataModel.overview
    )

    fun toDbEntities(movies: List<Movie>): List<MovieDbEntity> {
        return movies.map {
            toDbEntity(it)
        }
    }

    private fun toDbEntity(movie: Movie) = MovieDbEntity(
        id = movie.id,
        title = movie.title,
        releaseDate = movie.releaseDate,
        voteCount = movie.voteCount,
        posterPath = movie.posterPath,
        popularity = movie.popularity,
        originalLanguage = movie.originalLanguage,
        voteAverage = movie.voteAverage,
        adult = movie.adult,
        genreId = movie.genre.id,
        backdropPath = movie.backdropPath,
        overview = movie.overview
    )

    fun fromDbToEntities(movieDbEntities: List<MovieDbEntity>) : List<Movie> {
        return movieDbEntities.map {
            fromDbToEntity(it)
        }
    }

    private fun fromDbToEntity(movieDbEntity: MovieDbEntity): Movie {
        return Movie(
            id = movieDbEntity.id,
            title = movieDbEntity.title,
            releaseDate = movieDbEntity.releaseDate,
            overview = movieDbEntity.overview,
            backdropPath = movieDbEntity.backdropPath,
            adult = movieDbEntity.adult,
            voteAverage = movieDbEntity.voteAverage,
            originalLanguage = movieDbEntity.originalLanguage,
            popularity = movieDbEntity.popularity,
            posterPath = movieDbEntity.posterPath,
            voteCount = movieDbEntity.voteCount,
            genre = GenreDataSource.getGenreById(movieDbEntity.genreId)
        )
    }
}