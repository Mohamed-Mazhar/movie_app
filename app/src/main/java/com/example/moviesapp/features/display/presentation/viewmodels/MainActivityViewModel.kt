package com.example.moviesapp.features.display.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.features.display.domain.usecases.GetDeleteDatabaseTaskScheduledUsecase
import com.example.moviesapp.features.display.domain.usecases.SetDeleteDatabaseTaskUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getDeleteDatabaseScheduledUsecase: GetDeleteDatabaseTaskScheduledUsecase,
    private val setDeleteDatabaseStatusUsecase: SetDeleteDatabaseTaskUsecase
) : ViewModel(), CoroutineScope {

    private val isDeleteTaskScheduledLiveData = MutableLiveData<Boolean>()
    private val job: Job = Job()
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    fun getDeleteTaskStatus() = launch(coroutineContext) {
        val isDeleteTaskScheduled = getDeleteDatabaseScheduledUsecase.get()
        isDeleteTaskScheduledLiveData.value = isDeleteTaskScheduled
        if (!isDeleteTaskScheduled) {
            Log.d("MovieApp", "Scheduling task")
            setDeleteDatabaseStatusUsecase.set()
        }
    }

    fun getIsDeleteTaskScheduled() = isDeleteTaskScheduledLiveData

}