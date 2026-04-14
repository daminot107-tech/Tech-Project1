package com.example.imdbclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbclone.adapter.MovieAdapter
import com.example.imdbclone.databinding.ActivityMainBinding
import com.example.imdbclone.utils.Constant.Companion.MY_TOKEN
import com.example.imdbclone.utils.TokenManager
import com.example.imdbclone.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel.Movieviewmodel by viewModels<MovieViewModel.Movieviewmodel>()
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var tokenManager: TokenManager
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tokenManager.saveToken(MY_TOKEN)
        binding.RV.layoutManager=LinearLayoutManager(this)
        viewModel.getMovieList()
        viewModel.movieListLiveData.observe(this) {
            val list = it.data?.results
            adapter = MovieAdapter(list)
            binding.RV.adapter = adapter

        }

    }
}
