package com.egaragul.androidfundametals.ui.movies

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.databinding.ItemMovieListBinding
import com.egaragul.androidfundametals.ui.movies.data.Movie

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
class MovieViewHolder(
        private val itemBinding : ItemMovieListBinding,
        private val clickListener : ((Int) -> Unit)
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(movie : Movie) {
        itemBinding.movieCoverIv.setImageResource(movie.image)
        itemBinding.tvAgeRate.text = movie.ageRate
        itemBinding.tvGenre.text = movie.genre
        itemBinding.tvTitle.text = movie.title
        itemBinding.rbRating.rating = movie.rating.toFloat()

        val reviews = "${movie.reviews} reviews"
        itemBinding.tvReviews.text = reviews

        val duration = "${movie.duration} MIN"
        itemBinding.tvMovieLength.text = duration

        itemBinding.root.setOnClickListener {
            clickListener(movie.id)
        }
    }
}