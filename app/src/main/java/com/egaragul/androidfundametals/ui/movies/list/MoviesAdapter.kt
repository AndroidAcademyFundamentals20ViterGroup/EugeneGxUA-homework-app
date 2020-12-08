package com.egaragul.androidfundametals.ui.movies.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egaragul.androidfundametals.databinding.ItemMovieListBinding
import com.egaragul.androidfundametals.ui.movies.data.Movie

/**
 * Created by Eugene Garagulya
 * Date: 07.12.2020
 */
class MoviesAdapter(private val clickListener: ((Movie) -> Unit)) : RecyclerView.Adapter<MovieViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val movies = mutableListOf<Movie>()

    fun submitMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    fun getMovies() : List<Movie> {
        return movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layout = ItemMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(layout, clickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}