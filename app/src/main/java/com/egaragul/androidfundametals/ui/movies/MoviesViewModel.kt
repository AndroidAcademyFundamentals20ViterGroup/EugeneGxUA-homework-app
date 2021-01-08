package com.egaragul.androidfundametals.ui.movies

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egaragul.androidfundametals.ui.movies.data.Movie
import com.egaragul.androidfundametals.utils.JsonMockFormatter
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    private val movies = MutableLiveData<List<Movie>>()
    val movieList : LiveData<List<Movie>>
        get() = movies


    val selectedMovie = MutableLiveData<Movie>()

    fun getMoviesForAdapter(context: Context) {
        viewModelScope.launch {
            movies.postValue(JsonMockFormatter.loadMovies(context))
        }
    }
}