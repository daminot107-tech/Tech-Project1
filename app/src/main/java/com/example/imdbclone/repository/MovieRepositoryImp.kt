package com.example.imdbclone.repository

import com.example.imdbclone.data.MovieResponse
import com.example.imdbclone.remote.MovieApi
import com.example.imdbclone.utils.NetworkResult
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val api: MovieApi) : MovieRepository {
    override suspend fun getMovieList(): NetworkResult<MovieResponse> {
        val response = api.getMovieList()
        return  try {
            if (response.isSuccessful) {
                NetworkResult.Success(response.body())
            } else {
                NetworkResult.Failed(response.message().toString())
            }
        }catch (e:Exception){
            NetworkResult.Failed(e.message.toString())
        }
    }
}