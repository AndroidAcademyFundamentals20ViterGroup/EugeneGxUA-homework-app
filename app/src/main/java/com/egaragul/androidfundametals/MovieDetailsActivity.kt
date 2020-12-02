package com.egaragul.androidfundametals

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egaragul.androidfundametals.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context) : Intent {
            return Intent(context, MovieDetailsActivity::class.java)
        }
    }

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        configUi()
    }

    private fun configUi() {

        binding.ivBackBtn.setOnClickListener {
            onBackPressed()
        }

        binding.tvAgeRate.text = getString(R.string.age_rate)
        binding.tvTitle.text = getString(R.string.avengers_title)
        binding.tvGenre.text = getString(R.string.avengers_genre)
        binding.tvStorylineDescription.text = getString(R.string.avengers_description)
        binding.tvReviews.text = getString(R.string.avengers_reviews)


    }
}