package com.example.moviesapp.common.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ResetDatabaseJobService: JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        val result = deleteDatabase("com.example.moviesapp")
        Log.d("MovieApp", "Job: Database deleted is $result")
        jobFinished(params, true)
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }
}