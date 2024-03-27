package com.ardaisitan.moviesapp.data.entity

import java.io.Serializable

data class Filmler(var id: Int, var ad: String, var resim:String , var fiyat: Int) :
    Serializable // Veri gondermek icin serializable yapmamiz gerekir.
