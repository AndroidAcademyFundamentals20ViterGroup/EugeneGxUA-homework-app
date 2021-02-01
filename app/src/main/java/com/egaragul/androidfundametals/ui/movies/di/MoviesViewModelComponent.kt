package com.egaragul.androidfundametals.ui.movies.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.egaragul.androidfundametals.ui.movies.viewmodel.MoviesViewModel

class MoviesViewModelComponent {

    private val model = ModelComponent().provideMoviesApi()

    fun provideMoviesViewModel(viewModelStoreOwner: ViewModelStoreOwner) : MoviesViewModel {
        return ViewModelProvider(viewModelStoreOwner, MoviesViewModelFactory(model)).get(
            MoviesViewModel::class.java
        )
    }
}