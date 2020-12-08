package com.egaragul.androidfundametals.ui.movies.details

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.databinding.FragmentMoviesDetailsBinding
import com.egaragul.androidfundametals.ui.movies.data.Actor
import com.egaragul.androidfundametals.ui.movies.data.Movie
import kotlinx.serialization.json.Json

class FragmentMoviesDetails : Fragment() {

    companion object {
        private const val ARGS_MOVIE = "MOVIE"

        fun newInstance(movie: Movie) : FragmentMoviesDetails {
            val bundle = Bundle()
            bundle.putString(ARGS_MOVIE, Json.encodeToString(Movie.serializer(), movie))

            val fragment = FragmentMoviesDetails()
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var binding: FragmentMoviesDetailsBinding

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString(ARGS_MOVIE)?.let {
            movie = Json.decodeFromString(Movie.serializer(), it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesDetailsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configUi()
    }

    private fun configUi() {

        binding.ivBackBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

        movie?.apply {

            binding.ivMovieCover.setImageResource(image)

            binding.tvAgeRate.text = ageRate
            binding.tvTitle.text = title
            binding.tvGenre.text = genre
            binding.tvStorylineDescription.text = getString(R.string.avengers_description)

            binding.rbRating.rating = rating.toFloat()
            val reviewsText = "$reviews reviews"
            binding.tvReviews.text = reviewsText

            setupActorsList(actors)
        }
    }

    private fun setupActorsList(actors : List<Actor>) {

        binding.rvCast?.let {
            val actorAdapter = ActorsAdapter()
            val divider = DividerItemDecoration(requireContext(), LinearLayout.HORIZONTAL)

            ContextCompat.getDrawable(requireContext(), R.drawable.divider_drawable)?.let { drawable ->
                divider.setDrawable(
                    drawable
                )
            }

            it.addItemDecoration(divider)
            it.adapter = actorAdapter

            actorAdapter.bindActors(actors)
            actorAdapter.notifyDataSetChanged()
        }
    }
}