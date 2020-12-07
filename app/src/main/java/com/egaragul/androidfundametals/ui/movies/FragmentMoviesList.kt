package com.egaragul.androidfundametals.ui.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.egaragul.androidfundametals.databinding.FragmentMoviesListBinding
import com.egaragul.androidfundametals.ui.movies.click_listeners.MovieDetailsClickListener
import com.egaragul.androidfundametals.ui.movies.data.MockHelper
import com.egaragul.androidfundametals.ui.movies.data.Movie

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

    private val moviesAdapter = MoviesAdapter { movieId ->
        movieDetailsClickListener?.onMovieItemClick(movieId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter.submitMovies(MockHelper.getMovies())

        binding.rvMovies?.let {
            it.adapter = moviesAdapter
            it.setHasFixedSize(true)
        }
    }

    private fun updateMovies(list : List<Movie>) {
        val oldList = moviesAdapter.getMovies()

        moviesAdapter.submitMovies(list)
        DiffUtil.calculateDiff(MovieDiffUtilCallback(oldList, list)).dispatchUpdatesTo(moviesAdapter)
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
