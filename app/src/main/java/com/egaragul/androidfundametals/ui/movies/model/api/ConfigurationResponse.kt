package com.egaragul.androidfundametals.ui.movies.model.api

import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationResponse(

	val images: Images? = null,

	val changeKeys: List<String?>? = null
) {
	@Serializable
	data class Images(
		val baseUrl: String? = null,
		val secureBaseUrl: String? = null,

		val posterSizes: List<String?>? = null,

		val backdropSizes: List<String?>? = null,

		val logoSizes: List<String?>? = null,

		val stillSizes: List<String?>? = null,

		val profileSizes: List<String?>? = null
	)
}



