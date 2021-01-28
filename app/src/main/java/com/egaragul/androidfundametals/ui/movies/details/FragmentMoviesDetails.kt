package com.egaragul.androidfundametals.ui.movies.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import coil.load
import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.databinding.FragmentMoviesDetailsBinding
import com.egaragul.androidfundametals.ui.movies.viewmodel.MoviesViewModel
import com.egaragul.androidfundametals.ui.movies.data.Actor

class FragmentMoviesDetails : Fragment() {

    companion object {

        const val TAG = "FragmentMoviesDetails"

        fun newInstance(): FragmentMoviesDetails {
            return FragmentMoviesDetails()
        }
    }

    private lateinit var binding: FragmentMoviesDetailsBinding

    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        viewModel.sMovie.observe(viewLifecycleOwner) {
            binding.ivMovieCover.load(it.detailImageUrl)

            binding.tvAgeRate.text = getString(R.string.pg_age_dec, it.pgAge)
            binding.tvTitle.text = it.title
            binding.tvGenre.text = it.genres.joinToString { genre -> genre.name }
            binding.tvStorylineDescription.text = it.storyLine

            binding.rbRating.rating = it.rating.toFloat() / 2
            binding.tvReviews.text = getString(R.string.dec_reviews, it.reviewCount)

            if (!it.actors.isNullOrEmpty()) {
                binding.tvCast.visibility = VISIBLE
                setupActorsList(it.actors)
            } else {
                binding.tvCast.visibility = INVISIBLE
            }
        }

        viewModel.getMovieDetail()
    }

    private fun setupActorsList(actors: List<Actor>) {

        binding.rvCast.apply {
            val divider = DividerItemDecoration(requireContext(), LinearLayout.HORIZONTAL)

            ContextCompat.getDrawable(requireContext(), R.drawable.divider_drawable)
                ?.let { drawable ->
                    divider.setDrawable(
                        drawable
                    )
                }

            addItemDecoration(divider)
            adapter = ActorsAdapter().also { adapter ->
                adapter.bindActors(actors)
                adapter.notifyDataSetChanged()
            }
        }
    }
}