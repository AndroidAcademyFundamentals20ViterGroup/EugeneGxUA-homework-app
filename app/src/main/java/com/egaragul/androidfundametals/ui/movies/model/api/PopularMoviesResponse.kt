package com.egaragul.androidfundametals.ui.movies.model.api

import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse(
	val page: Long? = null,
	val totalPages: Int? = null,
	val results: List<Movie>,
	val totalResults: Int? = null
) {
    @Serializable
    data class Movie(
		val id: Int? = null,

		val adult: Boolean? = null,

		val overview: String? = null,
		val originalLanguage: String? = null,
		val originalTitle: String? = null,
		val video: Boolean? = null,
		val title: String? = null,
		val genreIds: List<Long?>? = null,
		val posterPath: String? = null,
		val backdropPath: String? = null,
		val releaseDate: String? = null,
		val popularity: Double? = null,
		val voteAverage: Double? = null,


		val voteCount: Int? = null
	)
}


