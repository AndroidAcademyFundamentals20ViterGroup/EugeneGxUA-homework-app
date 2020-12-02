package com.egaragul.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egaragul.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnMovieDetails.setOnClickListener {
            startActivity(MovieDetailsActivity.getIntent(this))
        }
    }
}