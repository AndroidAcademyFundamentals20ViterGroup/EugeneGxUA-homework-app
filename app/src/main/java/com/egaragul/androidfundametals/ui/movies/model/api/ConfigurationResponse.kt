package com.egaragul.androidfundametals.ui.movies.model.api

import com.egaragul.androidfundametals.ui.movies.data.Images
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ConfigurationResponse(

	@SerialName("images")
	val images: Images? = null,

	@SerialName("change_keys")
	val changeKeys: List<String?>? = null
)



