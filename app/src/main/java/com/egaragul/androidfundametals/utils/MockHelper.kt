package com.egaragul.androidfundametals.utils

import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.ui.movies.data.Actor
import com.egaragul.androidfundametals.ui.movies.data.Movie

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
object MockHelper {

    fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                ageRate = "13+",
                genre = "Action, Adventure, Drama",
                4,
                127,
                "Avengers: End Game",
                137,
                R.mipmap.movie,
                false,
                getActors()
            ),
            Movie(
                id = 2,
                ageRate = "16+",
                genre = "Action, Sci-Fi, Thriller",
                5,
                98,
                "Tenet",
                97,
                R.mipmap.tenet,
                true,
                getActors()
            ),
            Movie(
                id = 3,
                ageRate = "13+",
                genre = "Action, Adventure, Sci-Fi",
                4,
                38,
                "Black Widow",
                102,
                R.mipmap.widow,
                false,
                getActors()
            ),
            Movie(
                id = 4,
                ageRate = "13+",
                genre = "Action, Adventure, Fantasy",
                5,
                74,
                "Wonder Woman 1984",
                120,
                R.mipmap.super_woman,
                false,
                getActors()
            ),
            Movie(
                id = 5,
                ageRate = "13+",
                genre = "Action, Adventure, Drama",
                4,
                127,
                "Avengers: End Game",
                137,
                R.mipmap.movie,
                false,
                getActors()
            ),
            Movie(
                id = 6,
                ageRate = "16+",
                genre = "Action, Sci-Fi, Thriller",
                5,
                98,
                "Tenet",
                97,
                R.mipmap.tenet,
                true,
                getActors()
            ),
        )
    }

    fun getActors() : List<Actor> {
        return listOf(
            Actor(
                1,
                R.mipmap.rdj,
                "Robert Downey Jr."
            ),
            Actor(
                2,
                R.mipmap.ce,
                "Chris Evans"
            ),
            Actor(
                3,
                R.mipmap.mr,
                "Mark Rufallo"
            ),
            Actor(
                4,
                R.mipmap.ch,
                "Chris Hamsworth"
            ),
            Actor(
                5,
                R.mipmap.ce,
                "Chris Evans"
            ),
            Actor(
                6,
                R.mipmap.mr,
                "Mark Rufallo"
            )
        )
    }
}