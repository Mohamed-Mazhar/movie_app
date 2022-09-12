package com.example.moviesapp.features.display.data.datasources.apis.movie

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("results")
    val movies: List<MovieDataModel>
)