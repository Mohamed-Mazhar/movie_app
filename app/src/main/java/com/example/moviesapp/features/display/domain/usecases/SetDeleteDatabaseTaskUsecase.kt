package com.example.moviesapp.features.display.domain.usecases

import com.example.moviesapp.features.display.data.repositories.SharedPreferencesAccess
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.SetDeleteDatabaseTaskUsecaseContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetDeleteDatabaseTaskUsecase @Inject constructor(
    private val sharedPreferencesAccess: SharedPreferencesAccess
) : SetDeleteDatabaseTaskUsecaseContract {

    override suspend fun set() = withContext(Dispatchers.Default) {
        sharedPreferencesAccess.scheduleDeleteTask()

    }
}