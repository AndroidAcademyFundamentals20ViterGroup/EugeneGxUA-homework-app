package com.egaragul.androidfundametals.ui.movies.model

import com.egaragul.androidfundametals.model.TheMovieDbService
import com.egaragul.androidfundametals.ui.movies.data.Images
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesModel(private val movieDbService: TheMovieDbService) {

    suspend fun getConfigurationAsync() : Images? {
        return movieDbService.getConfig().images
    }

    suspend fun getPopularMoviesAsync() = withContext(Dispatchers.IO) {
        movieDbService.getPopularMovies().results
    }

    suspend fun getGenresAsync() = withContext(Dispatchers.IO) {
        movieDbService.getGenres().genres
    }

    suspend fun getMovieDetailsAsync(movieId : Int) = withContext(Dispatchers.IO) {
        movieDbService.getMovieDetails(movieId)
    }

    suspend fun getMovieCreditsAsync(movieId: Int) = withContext(Dispatchers.IO) {
        movieDbService.getMovieCredits(movieId).cast
    }
}