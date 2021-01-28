package com.egaragul.androidfundametals.ui.movies.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCreditResponse(

	@SerialName("cast")
	val cast: List<Cast>? = null,

	@SerialName("id")
	val id: Int? = null,
) {
	@Serializable
	data class Cast(

		@SerialName("cast_id")
		val castId: Int? = null,

		@SerialName("character")
		val character: String? = null,

		@SerialName("gender")
		val gender: Int? = null,

		@SerialName("credit_id")
		val creditId: String? = null,

		@SerialName("known_for_department")
		val knownForDepartment: String? = null,

		@SerialName("original_name")
		val originalName: String? = null,

		@SerialName("popularity")
		val popularity: Double? = null,

		@SerialName("name")
		val name: String? = null,

		@SerialName("profile_path")
		val profilePath: String? = null,

		@SerialName("id")
		val id: Int? = null,

		@SerialName("adult")
		val adult: Boolean? = null,

		@SerialName("order")
		val order: Int? = null
	)
}


