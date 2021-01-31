package com.egaragul.androidfundametals.ui.movies.model.api

import com.egaragul.androidfundametals.ui.movies.data.Genre
import kotlinx.serialization.Serializable

@Serializable
class GenresResponse(
	val genres: List<Genre>? = null
)



