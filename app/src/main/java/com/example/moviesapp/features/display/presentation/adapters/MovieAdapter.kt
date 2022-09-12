package com.example.moviesapp.features.display.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.moviesapp.common.extensions.getPosterUrl
import com.example.moviesapp.common.utilities.AsyncDiffUtilCallback
import com.example.moviesapp.databinding.MovieItemBinding
import com.example.moviesapp.features.display.domain.entities.Movie
import com.example.moviesapp.features.display.presentation.adapters.MovieAdapter.MovieDataHolder
import com.example.moviesapp.features.display.presentation.screens.HomeFragmentDirections
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieDataHolder>() {

    private val differ: AsyncListDiffer<Any> =
        AsyncListDiffer(this, AsyncDiffUtilCallback<Any>())


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDataHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieDataHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieDataHolder, position: Int) {
        val media = differ.currentList[position]
        holder.bind(media as Movie)
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setData(moviesList: List<Movie>) {
        differ.submitList(moviesList)
    }

    class MovieDataHolder(private var binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            val posterUrl = movie.getPosterUrl()
            Glide.with(binding.posterImage).load(posterUrl).transform(CenterCrop())
                .into(binding.posterImage)
            binding.posterImage.clipToOutline = true
            binding.posterImage.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie)
                it.findNavController().navigate(action)
            }
        }

    }
}