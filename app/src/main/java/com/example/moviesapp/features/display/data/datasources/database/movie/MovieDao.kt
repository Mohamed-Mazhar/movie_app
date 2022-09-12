package com.example.moviesapp.features.display.data.datasources.database.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAll(): List<MovieDbEntity>

    @Insert
    fun insertMultiple(moviesList: List<MovieDbEntity>)
}