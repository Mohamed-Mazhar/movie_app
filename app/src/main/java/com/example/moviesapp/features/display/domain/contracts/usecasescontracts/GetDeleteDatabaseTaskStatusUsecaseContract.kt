package com.example.moviesapp.features.display.domain.contracts.usecasescontracts

interface GetDeleteDatabaseTaskStatusUsecaseContract {
    suspend fun get(): Boolean
}