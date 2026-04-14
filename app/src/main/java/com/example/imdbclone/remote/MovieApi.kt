package com.example.imdbclone.remote

import com.example.imdbclone.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("3/movie/top_rated?api_key=43209327df8c392799bb3fbf5bb03a54")
    suspend fun  getMovieList():Response<MovieResponse>
}