package com.ardaisitan.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardaisitan.moviesapp.data.entity.Filmler
import com.ardaisitan.moviesapp.data.repo.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(val mRepo : MoviesRepository) : ViewModel() {

    //val mRepo = MoviesRepository()  Bagimliliktir.

    val moviesList = MutableLiveData<List<Filmler>>()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            moviesList.value = mRepo.loadMovies() // Veritabanından gelen veriyi moviesList'e aktariyoruz
        }
    }

}