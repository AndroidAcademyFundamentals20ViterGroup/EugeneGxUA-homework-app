package com.egaragul.androidfundametals.ui.movies.list

import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.databinding.ItemMovieListBinding
import com.egaragul.androidfundametals.ui.movies.data.Movie

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
class MovieViewHolder(
        private val itemBinding : ItemMovieListBinding,
        private val clickListener : ((Movie) -> Unit)
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(movie : Movie) {
        itemBinding.movieCoverIv.load(movie.imageUrl) {
            transformations(RoundedCornersTransformation(
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    4f,
                    itemView.context.resources.displayMetrics
                )
            ))
        }
        itemBinding.tvAgeRate.text = context.getString(R.string.pg_age_dec, movie.pgAge)
        itemBinding.tvGenre.text = movie.genres.joinToString { genre -> genre.name }
        itemBinding.tvTitle.text = movie.title

        itemBinding.rbRating.setIsIndicator(true)
        itemBinding.rbRating.rating = movie.rating.toFloat() / 2

        itemBinding.tvReviews.text = context.getString(R.string.dec_reviews, movie.reviewCount)


        itemBinding.tvMovieLength.text = context.getString(R.string.dec_movie_duration, movie.runningTime)

        itemBinding.root.setOnClickListener {
            clickListener(movie)
        }
    }

    private val RecyclerView.ViewHolder.context
        get() = this.itemView.context
}