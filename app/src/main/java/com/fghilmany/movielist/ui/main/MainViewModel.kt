package com.fghilmany.movielist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fghilmany.movielist.core.data.MovieRepository
import com.fghilmany.movielist.core.data.Resource
import com.fghilmany.movielist.core.data.source.remote.response.Results
import kotlinx.coroutines.launch


class MainViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private var _movie: MutableLiveData<Resource<List<Results>?>> = MutableLiveData()
    val movie = _movie
    fun getMovie(){
        viewModelScope.launch {
            movieRepository.getMovie().collect{
                _movie.value = it
            }
        }
    }
}