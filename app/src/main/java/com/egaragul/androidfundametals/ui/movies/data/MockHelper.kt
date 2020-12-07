package com.egaragul.androidfundametals.ui.movies.data

import com.egaragul.androidfundametals.R

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
                emptyList()
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
                emptyList()
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
                emptyList()
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
                emptyList()
            ),
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
                emptyList()
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
                emptyList()
            ),
        )
    }
}