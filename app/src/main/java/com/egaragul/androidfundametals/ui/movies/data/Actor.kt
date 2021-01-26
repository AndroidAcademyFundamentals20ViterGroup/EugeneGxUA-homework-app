package com.egaragul.androidfundametals.ui.movies.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
@Serializable
data class Actor(
        @SerialName("id")
        val id: Int,

        @SerialName("name")
        val name: String,

        @SerialName("imageUrl")
        val imageUrl: String,
)