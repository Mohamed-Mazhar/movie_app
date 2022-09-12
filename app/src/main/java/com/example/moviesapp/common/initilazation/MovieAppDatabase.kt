package com.example.moviesapp.common.initilazation

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.features.display.data.datasources.database.movie.MovieDao
import com.example.moviesapp.features.display.data.datasources.database.movie.MovieDbEntity


@Database(entities = [MovieDbEntity::class], version = 1, exportSchema = false)
abstract class MovieAppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}