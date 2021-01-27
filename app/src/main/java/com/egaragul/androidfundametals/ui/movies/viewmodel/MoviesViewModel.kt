package com.egaragul.androidfundametals.ui.movies.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.egaragul.androidfundametals.ui.movies.data.Genre
import com.egaragul.androidfundametals.ui.movies.data.Movie
import com.egaragul.androidfundametals.ui.movies.model.MoviesModel
import com.egaragul.androidfundametals.ui.movies.model.api.ConfigurationResponse
import com.egaragul.androidfundametals.utils.JsonMockFormatter
import kotlinx.coroutines.*

class MoviesViewModel(private val model: MoviesModel) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(
            "MoviesViewModel",
            "Coroutine exception, scope active:${viewModelScope.isActive}",
            throwable
        )
    }

    private val movies = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = movies

    private val imageConfiguration = MutableLiveData<ConfigurationResponse.Images>()
    val imageConfig: LiveData<ConfigurationResponse.Images>
        get() = imageConfiguration


    val selectedMovie = MutableLiveData<Movie>()

    fun getMoviesForAdapter(context: Context) {
        viewModelScope.launch {
            movies.postValue(JsonMockFormatter.loadMovies(context))
        }
    }

    fun getMoviesForAdapter() {
        viewModelScope.launch(exceptionHandler) {
            val config = withContext(Dispatchers.IO) { model.getConfiguration() }
            val moviesList = model.getPopularMovies()
            val genres = model.getGenres()


            launch(Dispatchers.Default) {
                moviesList.let { movieItem ->
                    val transformedList = movieItem.map { movie ->
                        Movie(
                            id = movie.id ?: -1,
                            pgAge = if (movie.adult == true) {
                                18
                            } else {
                                16
                            },
                            title = movie.title ?: "No title",
                            genres = genres?.filter { genre ->
                                movie.genreIds?.contains(genre.id) ?: false
                            }?.map { genreResp ->
                                Genre(
                                    id = genreResp.id ?: -1,
                                    name = genreResp.name ?: "No tag"
                                )
                            } ?: emptyList(),
                            runningTime = 0,
                            reviewCount = movie.voteCount ?: 0,
                            isLiked = false,
                            rating = movie.voteAverage?.div(2)?.toInt() ?: 0,
                            imageUrl = config?.secureBaseUrl + (config?.posterSizes?.get(3)
                                ?: "") + movie.posterPath,
                            detailImageUrl = "",
                            storyLine = "",
                            actors = emptyList()
                        )
                    }
                    launch(Dispatchers.Main) {
                        movies.value = transformedList
                    }
                }
            }
        }
    }
}