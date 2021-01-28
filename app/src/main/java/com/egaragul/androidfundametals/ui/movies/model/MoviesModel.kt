package com.egaragul.androidfundametals.ui.movies.model

import com.egaragul.androidfundametals.di.RetrofitModule
import com.egaragul.androidfundametals.model.TheMovieDbService
import com.egaragul.androidfundametals.ui.movies.data.Images
import com.egaragul.androidfundametals.ui.movies.model.api.ConfigurationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesModel(private val movieDbService: TheMovieDbService) {

    suspend fun getConfiguration() : Images? {
        return movieDbService.getConfig().images
    }

    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        movieDbService.getPopularMovies().results
    }

    suspend fun getGenres() = withContext(Dispatchers.IO) {
        movieDbService.getGenres().genres
    }

    suspend fun getMovieDetails(movieId : Int) = withContext(Dispatchers.IO) {
        movieDbService.getMovieDetails(movieId)
    }
}