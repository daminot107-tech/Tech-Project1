package com.example.imdbclone.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbclone.data.MovieResponse
import com.example.imdbclone.repository.MovieRepositoryImp
import com.example.imdbclone.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel {
    @HiltViewModel
    class Movieviewmodel @Inject constructor(private val repositoryImp: MovieRepositoryImp):
        ViewModel() {
        private val _movielistLiveData = MutableLiveData<NetworkResult<MovieResponse>>()
        val movieListLiveData : LiveData<NetworkResult<MovieResponse>>
            get() = _movielistLiveData
        init {
            getMovieList()
        }

        fun getMovieList(){
            viewModelScope.launch{
                val response=repositoryImp.getMovieList()
                _movielistLiveData.value=response
                Log.d("MyResponse","$response")
            }
        }
    }
}