package com.fghilmany.movielist.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fghilmany.movielist.core.data.MovieRepository


class MainViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getMovie() = movieRepository.getMovie().asLiveData()
}