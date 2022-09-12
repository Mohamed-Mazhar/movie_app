package com.example.moviesapp.features.display.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.common.utilities.AsyncDiffUtilCallback
import com.example.moviesapp.databinding.GenreMoviesBinding
import com.example.moviesapp.features.display.presentation.adapters.GenreAdapter.GenreMoviesViewHolder
import com.example.moviesapp.features.display.presentation.viewentity.GenreViewEntity
import javax.inject.Inject


class GenreAdapter @Inject constructor() :
    RecyclerView.Adapter<GenreMoviesViewHolder>() {

    private val differ: AsyncListDiffer<Any> =
        AsyncListDiffer(this, AsyncDiffUtilCallback<Any>())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreMoviesViewHolder {
        val binding = GenreMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreMoviesViewHolder, position: Int) {
        val genreMovies = differ.currentList[position]
        holder.bind(genreMovies as GenreViewEntity)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setData(genresList: List<GenreViewEntity>) {
       differ.submitList(genresList)
    }

    class GenreMoviesViewHolder(private var binding: GenreMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(genreMovies: GenreViewEntity) {
            val movieAdapter = MovieAdapter()
            binding.moviesList.adapter = movieAdapter
            binding.moviesList.layoutManager = LinearLayoutManager(
                binding.root.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            movieAdapter.setData(genreMovies.movies)
            binding.moviesList.setHasFixedSize(true)
            binding.genreType.text = genreMovies.genre
        }
    }
}