package com.example.movie.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.API.APIClient
import com.example.movie.API.nowplayinginterface
import com.example.movie.API.popularinterface
import com.example.movie.Adapter.MovielistAdapter
import com.example.movie.Modelclass.Movielistmodel
import com.example.movie.Modelclass.ResultsItem
import com.example.movie.databinding.FragmentNowPlayingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NowPlayingFragment : Fragment() {

    lateinit var binding: FragmentNowPlayingBinding
    lateinit var adapter: MovielistAdapter
    var list = ArrayList<ResultsItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNowPlayingBinding.inflate(layoutInflater)

        adapter = MovielistAdapter()
        callapi()

        return binding.root
    }

    private fun callapi() {

        var api = APIClient.getapiclient().create(nowplayinginterface::class.java)

        api.getnowplayingmovie().enqueue(object : Callback<Movielistmodel> {

            override fun onResponse(
                call: Call<Movielistmodel>,
                response: Response<Movielistmodel>
            ) {
                if (response.isSuccessful) {
                    var movielist = response.body()?.results

                    list.addAll(movielist as ArrayList<ResultsItem>)

                    adapter.setmovie(list)

                    binding.rcv.layoutManager = LinearLayoutManager(context)
                    binding.rcv.adapter = adapter


                }
            }


            override fun onFailure(call: Call<Movielistmodel>, t: Throwable) {
            }

        })


    }
}