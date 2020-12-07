package com.egaragul.androidfundametals.ui.movies.data

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
data class Movie(
        val id : Int,
        val ageRate : String,
        val genre : String,
        val rating : Int,
        val reviews : Int,
        val title : String,
        val duration : Int,
        val image : Int,
        val like : Boolean,
        val actors : List<Actor>
)