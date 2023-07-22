package com.fghilmany.movielist.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fghilmany.movielist.core.data.source.remote.response.Results
import com.fghilmany.movielist.databinding.ItemMovieBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val listMovie = arrayListOf<Results>()

    fun setList(list: List<Results>?){
        if (!list.isNullOrEmpty()){
            notifyItemRangeRemoved(0, listMovie.size)
            listMovie.clear()
            listMovie.addAll(list)
            notifyItemRangeChanged(0, listMovie.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = listMovie[position]
        holder.bind(result)
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)
        fun bind(result: Results) {
            with(binding){
                result.apply {
                    Glide.with(itemView.context)
                        .load(posterPath)
                        .into(ivPoster)
                    tvTitle.text = title
                }
            }
        }

    }
}