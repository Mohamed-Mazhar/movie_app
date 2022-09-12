package com.example.moviesapp.features.display.domain.contracts.usecasescontracts

interface GetDeleteDatabaseTaskScheduledUsecaseContract {
    suspend fun get(): Boolean
}