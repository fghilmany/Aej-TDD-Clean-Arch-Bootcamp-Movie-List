package com.fghilmany.movielist.core.data

import com.fghilmany.movielist.core.data.source.remote.response.Results
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovie(): Flow<Resource<List<Results>>>
}