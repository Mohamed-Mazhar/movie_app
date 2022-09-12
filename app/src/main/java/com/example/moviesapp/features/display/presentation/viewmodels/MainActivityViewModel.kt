package com.example.moviesapp.features.display.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetDeleteDatabaseTaskScheduledUsecaseContract
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.SetDeleteDatabaseTaskUsecaseContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getDeleteDatabaseScheduledUsecase: GetDeleteDatabaseTaskScheduledUsecaseContract,
    private val setDeleteDatabaseStatusUsecase: SetDeleteDatabaseTaskUsecaseContract
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