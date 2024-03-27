package com.ardaisitan.moviesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ardaisitan.moviesapp.R
import com.ardaisitan.moviesapp.data.entity.Filmler
import com.ardaisitan.moviesapp.databinding.CardDesignBinding
import com.ardaisitan.moviesapp.ui.fragment.MainFragmentDirections
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(val mContext: Context, val moviesList: List<Filmler>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CardDesignBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_design,
            parent,
            false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        val d = holder.binding

        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${movie.resim}"//Gelen film nesnesinin resmini aktaririz.
        Glide.with(mContext).load(url).override(500, 750).into(d.imageView)


        d.movieObjectt = movie


        d.cardViewMovie.setOnClickListener {
            val direction =
                MainFragmentDirections.mainToDetailPage(movie) // Hangi filmi secersem onun nesnesini yollariz.
            Navigation.findNavController(it).navigate(direction)

        }

        d.buttonAdd.setOnClickListener { it ->
            Snackbar.make(it, "Add ${movie.ad} to chart ?", Snackbar.LENGTH_SHORT)
                .setAction("Add") {
                    Snackbar.make(it, "${movie.ad} added.", Snackbar.LENGTH_SHORT)
                        .show()
                }
                .show()
        }


    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}