package com.egaragul.androidfundametals.ui.movies.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.egaragul.androidfundametals.databinding.FragmentMoviesListBinding
import com.egaragul.androidfundametals.ui.click_listeners.MovieDetailsClickListener
import com.egaragul.androidfundametals.ui.movies.di.MoviesViewModelComponent

/**
 * Created by Eugene Garagulya
 * Date: 02.12.2020
 */
class FragmentMoviesList : Fragment() {

    companion object {
        fun newInstance() = FragmentMoviesList()
    }

    private lateinit var binding : FragmentMoviesListBinding
    private val viewModel by lazy {
        MoviesViewModelComponent().provideMoviesViewModel(requireActivity())
    }

    private var movieDetailsClickListener : MovieDetailsClickListener? = null

    private val moviesAdapter = MoviesAdapter { movie ->
        viewModel.selectedMovieId.value = movie.id
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
        }

        viewModel.getMoviesForAdapter()
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
