package com.fghilmany.movielist.core.data

import com.fghilmany.movielist.core.data.source.remote.RemoteDataSource
import com.fghilmany.movielist.core.data.source.remote.network.ApiResponse
import com.fghilmany.movielist.core.data.source.remote.response.Results
import kotlinx.coroutines.flow.Flow

class ImplMovieRepository(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {
    override fun getMovie(): Flow<Resource<List<Results>>> {
        return object : RepositoryLoader<List<Results>>(){
            override suspend fun createCall(): Flow<ApiResponse<List<Results>>> {
                return remoteDataSource.getMovie()
            }
        }.asFlow()
    }
}