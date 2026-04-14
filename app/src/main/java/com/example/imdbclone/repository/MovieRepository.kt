package com.example.imdbclone.repository

import com.example.imdbclone.data.MovieResponse
import com.example.imdbclone.utils.NetworkResult

interface MovieRepository {
    suspend fun getMovieList(): NetworkResult<MovieResponse>
}