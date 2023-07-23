package com.fghilmany.movielist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.fghilmany.movielist.core.data.Resource
import com.fghilmany.movielist.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: MainViewModel by viewModel()
    private val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUi()
        observeMovie()
        viewModel.getMovie()
    }

    private fun observeMovie() {
        viewModel.movie.observe(this){
            when(it){
                is Resource.Loading -> {
                    with(binding){
                        pbLoading.visibility = View.VISIBLE
                        layoutEmpty.root.visibility = View.GONE
                    }
                }
                is Resource.Success -> {
                    with(binding){
                        pbLoading.visibility = View.GONE
                        layoutEmpty.root.visibility = View.GONE
                        adapter.setList(it.data)
                    }
                }
                is Resource.Error -> {
                    with(binding){
                        pbLoading.visibility = View.GONE
                        layoutEmpty.apply {
                            root.visibility = View.VISIBLE
                            tvMessage.text = it.message
                        }
                    }
                }
            }
        }
    }

    private fun initUi() {
        with(binding){
            rvMovie.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = this@MainActivity.adapter
            }

            root.setOnRefreshListener {
                viewModel.getMovie()
                root.isRefreshing = false
            }
        }
    }
}