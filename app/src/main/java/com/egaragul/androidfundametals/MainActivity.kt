package com.egaragul.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egaragul.androidfundametals.ui.click_listeners.MovieDetailsClickListener
import com.egaragul.androidfundametals.databinding.ActivityMainBinding
import com.egaragul.androidfundametals.ui.movies.FragmentMoviesList
import com.egaragul.androidfundametals.ui.movies.details.FragmentMoviesDetails

class MainActivity : AppCompatActivity(), MovieDetailsClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, FragmentMoviesList.newInstance())
                    .commit()
        }

    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            val lastFragment = supportFragmentManager.fragments.last()
            supportFragmentManager.beginTransaction()
                    .remove(lastFragment)
                    .commit()
        } else {
            super.onBackPressed()
        }
    }

    override fun onMovieItemClick(id: Int) {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, FragmentMoviesDetails.newInstance(id))
                .commitAllowingStateLoss()
    }
}