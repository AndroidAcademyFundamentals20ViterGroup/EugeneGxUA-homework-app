package com.egaragul.androidfundametals.ui.movies.data

import kotlinx.serialization.Serializable

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
@Serializable
data class Actor(
        val id: Int,
        val name: String,
        val imageUrl: String,
)