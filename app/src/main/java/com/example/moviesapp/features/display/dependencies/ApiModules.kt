package com.example.moviesapp.features.display.dependencies

import com.example.moviesapp.features.display.data.contracts.MovieServiceContract
import com.example.moviesapp.features.display.data.datasources.apis.movie.MovieApi
import com.example.moviesapp.features.display.data.services.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModules {

    private const val baseUrl = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun getMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Singleton
    @Provides
    fun getMovieService(movieService: MovieService) : MovieServiceContract = movieService

}