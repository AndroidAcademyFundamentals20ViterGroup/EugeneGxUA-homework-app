package com.egaragul.androidfundametals.ui.movies.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.egaragul.androidfundametals.ui.movies.data.Movie
import com.egaragul.androidfundametals.ui.movies.model.MoviesModel
import com.egaragul.androidfundametals.ui.movies.model.api.ConfigurationResponse
import com.egaragul.androidfundametals.utils.JsonMockFormatter
import kotlinx.coroutines.*

class MoviesViewModel(private val model : MoviesModel) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("MoviesViewModel", "Coroutine exception, scope active:${viewModelScope.isActive}", throwable)
    }

    private val movies = MutableLiveData<List<Movie>>()
    val movieList : LiveData<List<Movie>>
        get() = movies

    private val imageConfiguration = MutableLiveData<ConfigurationResponse.Images>()
    val imageConfig : LiveData<ConfigurationResponse.Images>
        get() = imageConfiguration


    val selectedMovie = MutableLiveData<Movie>()

    fun getMoviesForAdapter(context: Context) {
        viewModelScope.launch {
            movies.postValue(JsonMockFormatter.loadMovies(context))
        }
    }

    fun getMoviesForAdapter() {
        viewModelScope.launch(exceptionHandler) {
            val  config = async {
                model.getConfiguration()
            }.await()

            val moviesList = async {
                model.getPopularMovies()
            }.await()

            moviesList?.let {
                movies.postValue(
                    movieList.map {

                    }
                )
            }
        }
    }

}