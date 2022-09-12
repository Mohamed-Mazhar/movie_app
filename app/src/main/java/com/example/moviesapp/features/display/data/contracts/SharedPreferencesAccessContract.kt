package com.example.moviesapp.features.display.data.contracts

interface SharedPreferencesAccessContract {
    suspend fun isDeleteTaskScheduled(): Boolean

    suspend fun scheduleDeleteTask()
}