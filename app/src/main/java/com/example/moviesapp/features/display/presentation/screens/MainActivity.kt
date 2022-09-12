package com.example.moviesapp.features.display.presentation.screens

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.common.services.ResetDatabaseJobService
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.features.display.presentation.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val DELETE_DATABASE_JOB_ID = 1
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getIsDeleteTaskScheduled().observe(this) {
            scheduleDeleteJob(it)
        }
        viewModel.getDeleteTaskStatus()
    }

    private fun scheduleDeleteJob(isTaskScheduledBefore: Boolean) {
        if (!isTaskScheduledBefore) {
            val component = ComponentName(this, ResetDatabaseJobService::class.java)
            val jobInfo = JobInfo.Builder(DELETE_DATABASE_JOB_ID, component)
                .setPeriodic(4 * 60 * 60 * 1000)
                .build()
            val jobScheduler: JobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode = jobScheduler.schedule(jobInfo)
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.d("MovieApp", "Scheduler: Job completed successfully")
            } else {
                Log.d("MovieApp", "Scheduler: Job Failed")
            }
        }
    }
}