package com.egaragul.androidfundametals.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.egaragul.androidfundametals.R
import com.egaragul.androidfundametals.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {

    companion object {
        private const val ARGS_MOVIE_ID = "MOVIE_ID"

        fun newInstance(id : Int) : FragmentMoviesDetails {
            val bundle = Bundle()
            bundle.putInt(ARGS_MOVIE_ID, id)

            val fragment = FragmentMoviesDetails()
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var binding: FragmentMoviesDetailsBinding

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

        binding.tvAgeRate.text = getString(R.string.age_rate)
        binding.tvTitle.text = getString(R.string.avengers_title)
        binding.tvGenre.text = getString(R.string.avengers_genre)
        binding.tvStorylineDescription.text = getString(R.string.avengers_description)
        binding.tvReviews.text = getString(R.string.avengers_reviews)
    }
}