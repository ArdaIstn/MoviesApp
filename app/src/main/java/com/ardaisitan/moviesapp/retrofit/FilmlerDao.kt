package com.ardaisitan.moviesapp.retrofit

import com.ardaisitan.moviesapp.data.entity.FilmlerCevap
import retrofit2.http.GET

interface FilmlerDao {

    //http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php

    //http://kasimadalan.pe.hu/->BaseUrl
    //filmler_yeni/tum_filmler.php->Webservis URL

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun loadMovies(): FilmlerCevap // Kac adet film gelirse o kadarini arayuzde gosterecegiz.
}