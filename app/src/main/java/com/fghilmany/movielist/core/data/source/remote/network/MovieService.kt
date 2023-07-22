package com.fghilmany.movielist.core.data.source.remote.network

import com.fghilmany.movielist.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET

interface MovieService {
    @GET("discover/movie")
    suspend fun getMovies(): MovieResponse
}