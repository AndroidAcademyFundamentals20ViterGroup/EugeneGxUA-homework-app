package com.egaragul.androidfundametals.ui.movies.di

import com.egaragul.androidfundametals.di.RetrofitModule
import com.egaragul.androidfundametals.model.TheMovieDbService
import com.egaragul.androidfundametals.ui.movies.model.MoviesModel

class ModelComponent(private val moviesApi : TheMovieDbService = RetrofitModule.apiMovies) {

    fun provideMoviesApi() : MoviesModel {
        return MoviesModel(moviesApi)
    }
}