package com.egaragul.androidfundametals.ui.movies.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
@Serializable
data class Movie(
        val id: Int,
        val pgAge: Int,
        val title: String,
        val genres: List<Genre>,
        val runningTime: Int,
        val reviewCount: Int,
        val isLiked: Boolean,
        val rating: Int,
        val imageUrl: String,
        val detailImageUrl: String,
        val storyLine: String,
        val actors: List<Actor>,
)