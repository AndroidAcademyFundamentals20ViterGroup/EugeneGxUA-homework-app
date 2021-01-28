package com.egaragul.androidfundametals.ui.movies.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Images(
    @SerialName("base_url")
    val baseUrl: String? = null,

    @SerialName("secure_base_url")
    val secureBaseUrl: String? = null,

    @SerialName("poster_sizes")
    val posterSizes: List<String?>? = null,

    @SerialName("backdrop_sizes")
    val backdropSizes: List<String?>? = null,

    @SerialName("logo_sizes")
    val logoSizes: List<String?>? = null,

    @SerialName("still_sizes")
    val stillSizes: List<String?>? = null,

    @SerialName("profile_sizes")
    val profileSizes: List<String?>? = null
)
