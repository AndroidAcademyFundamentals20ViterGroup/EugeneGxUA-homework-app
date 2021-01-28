package com.egaragul.androidfundametals.ui.movies.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.egaragul.androidfundametals.ui.movies.data.Actor
import com.egaragul.androidfundametals.ui.movies.data.Genre
import com.egaragul.androidfundametals.ui.movies.data.Images
import com.egaragul.androidfundametals.ui.movies.data.Movie
import com.egaragul.androidfundametals.ui.movies.model.MoviesModel
import com.egaragul.androidfundametals.ui.movies.model.api.GenresResponse
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

    val selectedMovieId = MutableLiveData<Int>()
    val sMovie = MutableLiveData<Movie>()

    private var config: Images? = null
    private val genres = mutableListOf<GenresResponse.Genre>()

    fun getMovieDetail() {
        viewModelScope.launch(exceptionHandler) {
            selectedMovieId.value?.let { id ->
                val loadedMovie = model.getMovieDetails(id)
                val cast = model.getMovieCredits(id)

                val movie = async(Dispatchers.Default) {
                    Movie(
                        id = loadedMovie.id ?: -1,
                        pgAge = if (loadedMovie.adult == true) {
                            18
                        } else {
                            16
                        },
                        title = loadedMovie.originalTitle ?: "No title",
                        genres = loadedMovie.genres?.map {
                            Genre(
                                it?.id?.toLong() ?: -1,
                                it?.name ?: ""
                            )
                        }
                            ?: emptyList(),
                        runningTime = 0,
                        reviewCount = loadedMovie.voteCount ?: 0,
                        isLiked = false,
                        rating = loadedMovie.voteAverage?.div(2)?.toInt() ?: 0,
                        imageUrl = config?.secureBaseUrl + (config?.posterSizes?.get(3)
                            ?: "" + loadedMovie.backdropPath),
                        detailImageUrl = config?.secureBaseUrl + (config?.backdropSizes?.get(2)
                            ?: "") + loadedMovie.backdropPath,
                        storyLine = loadedMovie.overview ?: "No storyline",
                        actors = cast?.map {
                            Actor(
                                id = it.id ?: -1,
                                name = it.name ?: "",
                                imageUrl = config?.secureBaseUrl + (config?.profileSizes?.get(3)) + it.profilePath,
                            )
                        } ?: emptyList()
                    )
                }.await()

                setData {
                    sMovie.value = movie
                }

            }
        }
    }

    fun getMoviesForAdapter() {
        viewModelScope.launch(exceptionHandler) {
            config = withContext(Dispatchers.IO) { model.getConfiguration() }

            val moviesList = model.getPopularMovies()
            model.getGenres()?.let {
                genres.addAll(it)
            }


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
                    setData {
                        movies.value = transformedList
                    }
                }
            }
        }
    }

    private fun setData(function: () -> Unit) {
        viewModelScope.launch {
            launch(Dispatchers.Main) {
                function()
            }
        }
    }
}