package com.example.moviesapp.features.display.dependencies

import com.example.moviesapp.features.display.data.contracts.MovieRepositoryContract
import com.example.moviesapp.features.display.data.repositories.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRepositoryContractModule {

    @Binds
    abstract fun getMovieRepository(
        movieRepository: MovieRepository
    ): MovieRepositoryContract

}