package com.example.moviesapp.features.display.presentation.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.HomeFragmentBinding
import com.example.moviesapp.features.display.presentation.adapters.GenreAdapter
import com.example.moviesapp.features.display.presentation.viewentity.GenreViewEntity
import com.example.moviesapp.features.display.presentation.viewmodels.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val  binding get() = _binding!!

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovies()
        viewModel.getLiveData().observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    private fun updateUI(genreMovies: List<GenreViewEntity>) {
        val genreAdapter = GenreAdapter()
        genreAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT
        val manager = LinearLayoutManager(context)
        binding.genresList.layoutManager = manager
        binding.genresList.adapter = genreAdapter
        genreAdapter.setData(genreMovies)
    }

    override fun onDestroy() {
        Log.d("LifeCycle", "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}