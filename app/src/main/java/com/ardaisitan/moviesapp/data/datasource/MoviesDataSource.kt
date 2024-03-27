package com.ardaisitan.moviesapp.data.datasource

import com.ardaisitan.moviesapp.data.entity.Filmler
import com.ardaisitan.moviesapp.retrofit.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesDataSource(var moviesDao: FilmlerDao) {
    suspend fun loadMovies(): List<Filmler> = //Filmleri asenkron bir bicimde iletiriz.
        withContext(Dispatchers.IO) {

            return@withContext moviesDao.loadMovies().filmler
        }

}