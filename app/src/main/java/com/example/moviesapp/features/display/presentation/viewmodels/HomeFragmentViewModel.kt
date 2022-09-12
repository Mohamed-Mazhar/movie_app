package com.example.moviesapp.features.display.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.features.display.data.datasources.cached.GenreDataSource
import com.example.moviesapp.features.display.domain.contracts.usecasescontracts.GetMoviesUsecaseContract
import com.example.moviesapp.features.display.presentation.viewentity.GenreViewEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getMoviesUsecase: GetMoviesUsecaseContract
) : ViewModel(), CoroutineScope {

    private val job: Job = Job()
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job
    private val genreMoviesLiveData = MutableLiveData<List<GenreViewEntity>>()

    fun getLiveData() = genreMoviesLiveData

    fun getMovies() = launch(coroutineContext) {
        val genresMovies = mutableListOf<GenreViewEntity>()
        val movies = getMoviesUsecase.get()
        val genres = GenreDataSource.genres.toList()
        genres.map { genre ->
            genresMovies.add(
                GenreViewEntity(
                    genre = genre.second,
                    movies = movies.filter { it.genre.id == genre.first })
            )
        }
        val filteredList = genresMovies.filter {
            it.movies.isNotEmpty()
        }
        updateLiveData(filteredList)
    }

    private fun updateLiveData(genreMoviesEntities: List<GenreViewEntity>) {
        genreMoviesLiveData.value = genreMoviesEntities
    }

}