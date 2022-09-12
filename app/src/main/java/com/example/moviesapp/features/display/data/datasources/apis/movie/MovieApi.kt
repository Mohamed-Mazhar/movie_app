package com.example.moviesapp.features.display.data.datasources.apis.movie

import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular?api_key=d498b5f5bbacb41b9824ddab13c8de37&page=4")
    suspend fun getMovies(): Response<GetMoviesResponse>

}
