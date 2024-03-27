package com.ardaisitan.moviesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ardaisitan.moviesapp.R
import com.ardaisitan.moviesapp.databinding.FragmentMainBinding
import com.ardaisitan.moviesapp.ui.adapter.MoviesAdapter
import com.ardaisitan.moviesapp.ui.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Resimleri glide ile gosterecegiz.Resimler internetten gelecek
 * Web servisle internette gelecek.
 */

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mainPageToolbarTitle = "Movies"

        viewModel.moviesList.observe(viewLifecycleOwner) {
            val moviesAdapter = MoviesAdapter(requireContext(), it)
            binding.moviesAdapter = moviesAdapter // Adapterimizi rv'ye aktardik.
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }


}