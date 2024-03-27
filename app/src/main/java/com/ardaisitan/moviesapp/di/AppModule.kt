package com.ardaisitan.moviesapp.di

import com.ardaisitan.moviesapp.data.datasource.MoviesDataSource
import com.ardaisitan.moviesapp.data.repo.MoviesRepository
import com.ardaisitan.moviesapp.retrofit.ApiUtils
import com.ardaisitan.moviesapp.retrofit.FilmlerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDao(): FilmlerDao {
        return ApiUtils.getMoviesDao()
    }

    @Provides
    @Singleton
    fun provideDataSource(moviesDao: FilmlerDao): MoviesDataSource {
        return MoviesDataSource(moviesDao)
    }

    // Singleton sayesinde tek bir nesne dondurup birden fazla yeri besleyebiliriz.

    @Provides
    @Singleton
    fun provideRepository(mDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepository(mDataSource)
    }

}