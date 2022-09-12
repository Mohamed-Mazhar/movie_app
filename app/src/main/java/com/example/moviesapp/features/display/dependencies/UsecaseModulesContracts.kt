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
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UsecaseModulesContracts {

    @Binds
    abstract fun bindGetMoviesUsecase(getMoviesUsecase: GetMoviesUsecase): GetMoviesUsecaseContract

    @Binds
    abstract fun bindGetDeleteDatabaseTaskUsecase(
        getDeleteDatabaseTaskScheduledUsecase: GetDeleteDatabaseTaskScheduledUsecase
    ): GetDeleteDatabaseTaskStatusUsecaseContract

    @Binds
    abstract fun bindSetDeleteDatabaseTaskUsecase(
        setDeleteDatabaseTaskUsecase: SetDeleteDatabaseTaskUsecase)
    : SetDeleteDatabaseTaskUsecaseContract

}