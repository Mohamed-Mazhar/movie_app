package com.example.moviesapp.features.display.data.repositories

import com.example.moviesapp.features.display.data.contracts.SharedPreferencesAccessContract
import com.example.moviesapp.features.display.data.datasources.sharedpreferences.SharedPreferences
import javax.inject.Inject

class SharedPreferencesAccess @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SharedPreferencesAccessContract {

    companion object {
        const val SCHEDULE_DELETE_TASK = "SCHEDULE_DELETE_TASK"
    }

    override suspend fun isDeleteTaskScheduled(): Boolean {
        return sharedPreferences.getBoolean(SCHEDULE_DELETE_TASK)
    }

    override suspend fun scheduleDeleteTask() {
        sharedPreferences.setBoolean(SCHEDULE_DELETE_TASK, true)
    }

}