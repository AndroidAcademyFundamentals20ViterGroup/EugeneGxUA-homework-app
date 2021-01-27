package com.egaragul.androidfundametals.model

import com.egaragul.androidfundametals.di.RetrofitModule
import com.egaragul.androidfundametals.di.RetrofitModule.PARAM_API_KEY
import com.egaragul.androidfundametals.di.RetrofitModule.PARAM_LANGUAGE
import com.egaragul.androidfundametals.di.RetrofitModule.PARAM_PAGE

import com.egaragul.androidfundametals.ui.movies.model.api.ConfigurationResponse
import com.egaragul.androidfundametals.ui.movies.model.api.GenresResponse
import com.egaragul.androidfundametals.ui.movies.model.api.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService {

    @GET("configuration")
    suspend fun getConfig(
        @Query(PARAM_API_KEY) apiKey : String = RetrofitModule.API_KEY
    ) : ConfigurationResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(PARAM_API_KEY) apiKey: String = RetrofitModule.API_KEY,
        @Query(PARAM_LANGUAGE) language : String = RetrofitModule.DEFAULT_LANGUAGE,
        @Query(PARAM_PAGE) page : Int = 1
    ) : PopularMoviesResponse

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query(PARAM_API_KEY) apiKey: String = RetrofitModule.API_KEY,
        @Query(PARAM_LANGUAGE) language: String = RetrofitModule.DEFAULT_LANGUAGE
    ) : GenresResponse
}
