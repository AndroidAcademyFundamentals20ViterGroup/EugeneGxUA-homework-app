package com.egaragul.androidfundametals.ui.movies.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class PopularMoviesResponse(
	@SerialName("page")
	val page: Long? = null,

	@SerialName("total_pages")
	val totalPages: Int? = null,

	@SerialName("results")
	val results: List<Movie>,

	@SerialName("total_results")
	val totalResults: Int? = null
)

@Serializable
class Movie(

	@SerialName("id")
	val id: Int? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("overview")
	val overview: String? = null,

	@SerialName("original_language")
	val originalLanguage: String? = null,

	@SerialName("original_title")
	val originalTitle: String? = null,

	@SerialName("video")
	val video: Boolean? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("genre_ids")
	val genreIds: List<Long?>? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("vote_average")
	val voteAverage: Double? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null
)


