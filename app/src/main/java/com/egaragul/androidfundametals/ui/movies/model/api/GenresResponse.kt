package com.egaragul.androidfundametals.ui.movies.model.api

import kotlinx.serialization.Serializable

@Serializable
data class GenresResponse(
	val genres: List<Genre>? = null
) {
	@Serializable
	data class Genre(
		val name: String? = null,
		val id: Long? = null
	)
}



