package com.egaragul.androidfundametals.ui.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.egaragul.androidfundametals.ui.movies.viewmodel.MoviesViewModel
import com.egaragul.androidfundametals.ui.movies.model.MoviesModel
import java.lang.IllegalArgumentException

class MoviesViewModelFactory(private val model: MoviesModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(model) as T
        }
        throw IllegalArgumentException("Check what movies viewModel you try to implement")
    }
}