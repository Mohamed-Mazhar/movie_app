package com.example.moviesapp.features.display.dependencies

import com.example.moviesapp.features.display.data.repositories.MovieRepository
import com.example.moviesapp.features.display.data.repositories.SharedPreferencesAccess
import com.example.moviesapp.features.display.data.services.MovieService
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetDeleteDatabaseTaskStatusUsecaseContract
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetMoviesUsecaseContract
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.SetDeleteDatabaseTaskUsecaseContract
import com.example.moviesapp.features.display.domain.usecases.GetDeleteDatabaseTaskScheduledUsecase
import com.example.moviesapp.features.display.domain.usecases.GetMoviesUsecase
import com.example.moviesapp.features.display.domain.usecases.SetDeleteDatabaseTaskUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UsecaseModules {
    @Provides
    fun getMoviesUsecaseProvider(
        movieService: MovieService,
        movieRepository: MovieRepository
    ): GetMoviesUsecaseContract {
        return GetMoviesUsecase(movieService, movieRepository)
    }

    @Provides
    fun getDeleteDatabaseTaskUsecaseProvider(
        sharedPreferencesAccess: SharedPreferencesAccess
    ): GetDeleteDatabaseTaskStatusUsecaseContract {
        return GetDeleteDatabaseTaskScheduledUsecase(sharedPreferencesAccess)
    }

    @Provides
    fun getSetDeleteDatabaseTaskUsecaseProvider(
        sharedPreferencesAccess: SharedPreferencesAccess
    ): SetDeleteDatabaseTaskUsecaseContract {
        return SetDeleteDatabaseTaskUsecase(sharedPreferencesAccess)
    }
}