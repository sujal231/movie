package com.example.movie.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movie.API.APIClient
import com.example.movie.Fragment.BlankFragment
import com.example.movie.Modelclass.ResultsItem
import com.example.movie.databinding.MovielistitemBinding

class MovielistAdapter : Adapter<MovielistAdapter.MovieHolder>() {

    lateinit var list: List<ResultsItem?>
    lateinit var context: Context

    class MovieHolder(itemView: MovielistitemBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        context = parent.context
        var binding =
            MovielistitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.binding.apply {

            list.get(position)?.apply {
                Glide.with(context).load(APIClient.imgurl + posterPath).into(imgmovieposter)
                txttext.text = overview
                txttitle.text = originalTitle
                txtDate.text = releaseDate
            }
        }




    }

    fun setmovie(list: List<ResultsItem>) {
        this.list = list as List<ResultsItem?>
    }

}