package com.ardaisitan.moviesapp.data.repo

import com.ardaisitan.moviesapp.data.datasource.MoviesDataSource
import com.ardaisitan.moviesapp.data.entity.Filmler


class MoviesRepository(val mDataSource : MoviesDataSource) {

    // val mDataSource = MoviesDataSource()  Bagimliliktir.

    suspend fun loadMovies(): List<Filmler> = mDataSource.loadMovies()
}