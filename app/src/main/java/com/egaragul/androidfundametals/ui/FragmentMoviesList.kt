package com.egaragul.androidfundametals.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.egaragul.androidfundametals.databinding.FragmentMoviesListBinding
import com.egaragul.androidfundametals.ui.click_listeners.MovieDetailsClickListener

/**
 * Created by Eugene Garagulya
 * Date: 02.12.2020
 */
class FragmentMoviesList : Fragment() {

    companion object {
        fun newInstance() = FragmentMoviesList()
    }

    private lateinit var binding : FragmentMoviesListBinding

    private var movieDetailsClickListener : MovieDetailsClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.movieItem.setOnClickListener {
            movieDetailsClickListener?.onMovieItemClick(0)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieDetailsClickListener = context as MovieDetailsClickListener
    }

    override fun onDetach() {
        super.onDetach()
        movieDetailsClickListener = null
    }
}
