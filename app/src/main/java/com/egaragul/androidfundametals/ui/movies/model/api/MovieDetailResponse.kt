package com.egaragul.androidfundametals.ui.movies.model.api

import com.egaragul.androidfundametals.ui.movies.data.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieDetailResponse(
	@SerialName("original_language")
	val originalLanguage: String? = null,

	@SerialName("imdb_id")
	val imdbId: String? = null,

	@SerialName("video")
	val video: Boolean? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("revenue")
	val revenue: Int? = null,

	@SerialName("genres")
	val genres: List<Genre>? = null,

	@SerialName("popularity")
	val popularity: Double? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("vote_count")
	val voteCount: Int? = null,

	@SerialName("overview")
	val overview: String? = null,

	@SerialName("original_title")
	val originalTitle: String? = null,

	@SerialName("runtime")
	val runtime: Int? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("vote_average")
	val voteAverage: Double? = null,

	@SerialName("tagline")
	val tagline: String? = null,

	@SerialName("adult")
	val adult: Boolean? = null,

	@SerialName("homepage")
	val homepage: String? = null,

	@SerialName("status")
	val status: String? = null
)



