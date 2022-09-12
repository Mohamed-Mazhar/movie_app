package com.example.moviesapp.features.display.dependencies

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.common.initilazation.MovieAppDatabase
import com.example.moviesapp.features.display.data.datasources.database.movie.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModules {

    @Singleton
    @Provides
    fun getDatabaseInstance(@ApplicationContext applicationContext: Context): MovieAppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            MovieAppDatabase::class.java,
            "com.example.moviesapp"
        ).build()
    }

    @Singleton
    @Provides
    fun getMovieDao(appDatabase: MovieAppDatabase) : MovieDao {
        return appDatabase.movieDao()
    }

}