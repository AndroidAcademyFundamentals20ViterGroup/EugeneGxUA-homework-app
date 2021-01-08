package com.egaragul.androidfundametals.ui.movies.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.egaragul.androidfundametals.databinding.FragmentMoviesListBinding
import com.egaragul.androidfundametals.ui.click_listeners.MovieDetailsClickListener
import com.egaragul.androidfundametals.ui.movies.MoviesViewModel
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
    private val viewModel : MoviesViewModel by activityViewModels()

    private var movieDetailsClickListener : MovieDetailsClickListener? = null

    private val moviesAdapter = MoviesAdapter { movie ->
        viewModel.selectedMovie.value = movie
        movieDetailsClickListener?.onMovieItemClick()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMovies.let {
            it.adapter = moviesAdapter
            it.setHasFixedSize(true)
        }

        viewModel.movieList.observe(viewLifecycleOwner) { movies ->
            moviesAdapter.submitMovies(movies)
            moviesAdapter.notifyDataSetChanged()
        }

        viewModel.getMoviesForAdapter(requireContext())
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
