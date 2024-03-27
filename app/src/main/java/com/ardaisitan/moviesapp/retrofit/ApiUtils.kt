package com.ardaisitan.moviesapp.retrofit

class ApiUtils {
    companion object {
        val baseUrl = "http://kasimadalan.pe.hu/"

        fun getMoviesDao(): FilmlerDao {
            return RetrofitClient.getClient(baseUrl).create(FilmlerDao::class.java)
        }
    }

}