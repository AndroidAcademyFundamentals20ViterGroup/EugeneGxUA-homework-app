package com.egaragul.androidfundametals.ui.movies.data

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Long, val name: String
)
