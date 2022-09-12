package com.example.moviesapp.features.display.data.datasources.sharedpreferences

import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SharedPreferences(val context: Context) {

    companion object {
        const val PREF_FILE_NAME: String = "movie_app_shared_preferences"
    }

    suspend fun getBoolean(key: String): Boolean = withContext(Dispatchers.IO) {
        Log.d("MovieApp", "SharedPreference getting $key")
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getBoolean(key, false)
    }

    suspend fun setBoolean(key: String, value: Boolean) = withContext(Dispatchers.IO) {
        Log.d("MovieApp", "SharedPreference saving $key value $value")
        val pref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        Log.d("MovieApp", "SharedPreference File is $pref")
        if (pref == null) {
            return@withContext false
        }
        with(pref.edit()) {
            putBoolean(key, value)
            commit()
        }

    }


}