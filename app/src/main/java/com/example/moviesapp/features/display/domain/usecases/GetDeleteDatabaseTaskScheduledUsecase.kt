package com.example.moviesapp.features.display.domain.usecases

import com.example.moviesapp.features.display.data.repositories.SharedPreferencesAccess
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetDeleteDatabaseTaskScheduledUsecaseContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetDeleteDatabaseTaskScheduledUsecase @Inject constructor(
    private val sharedPreferencesAccess: SharedPreferencesAccess
) : GetDeleteDatabaseTaskScheduledUsecaseContract {

    override suspend fun get(): Boolean = withContext(Dispatchers.Default) {
        sharedPreferencesAccess.isDeleteTaskScheduled()
    }
}