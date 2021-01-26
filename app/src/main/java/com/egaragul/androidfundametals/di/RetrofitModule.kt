package com.egaragul.androidfundametals.di

import com.egaragul.androidfundametals.model.TheMovieDbService
import com.egaragul.androidfundametals.model.data.BaseGetRequest
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    const val API_KEY = "1f8769453e1cbd0a14f13b9a4643ce3c"
    const val PARAM_API_KEY = "api_key"
    const val PARAM_LANGUAGE = "language"
    const val DEFAULT_LANGUAGE = "en-US"
    const val PARAM_PAGE = "page"
    const val PARAM_QUERY = "query"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Suppress("EXPERIMENTAL_API_USAGE")
    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType()))
        .build()

    val apiMovies: TheMovieDbService = retrofit.create(TheMovieDbService::class.java)

    fun proceedApiKeyArgument() : BaseGetRequest{
        return BaseGetRequest()
    }
}