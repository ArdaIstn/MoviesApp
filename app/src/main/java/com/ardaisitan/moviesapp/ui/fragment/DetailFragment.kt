package com.ardaisitan.moviesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ardaisitan.moviesapp.R
import com.ardaisitan.moviesapp.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle: DetailFragmentArgs by navArgs()

        val movieInfo =
            bundle.movie // Gonderdigimiz nesneyi bu sekilde aliriz ve icerisindekilere erisiriz.

        binding.movieObject = movieInfo


        val url =
            "http://kasimadalan.pe.hu/filmler_yeni/resimler/${movieInfo.resim}"//Gelen film nesnesinin resmini aktaririz.
        Glide.with(this).load(url).override(500, 750).into(binding.imageViewMovie)

        return binding.root
    }


}