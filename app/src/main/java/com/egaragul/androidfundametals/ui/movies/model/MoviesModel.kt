package com.egaragul.androidfundametals.ui.movies.model

import com.egaragul.androidfundametals.di.RetrofitModule
import com.egaragul.androidfundametals.model.TheMovieDbService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesModel(private val movieDbService: TheMovieDbService) {

    suspend fun getConfiguration() = withContext(Dispatchers.IO) {
        movieDbService.getConfig().images
    }

    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        movieDbService.getPopularMovies()
    }
}