package com.example.movie.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.API.APIClient
import com.example.movie.API.upcominginterface
import com.example.movie.Adapter.MovielistAdapter
import com.example.movie.Modelclass.Movielistmodel
import com.example.movie.Modelclass.ResultsItem
import com.example.movie.databinding.FragmentUpcomingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpcomingFragment : Fragment() {
    lateinit var abapter: MovielistAdapter
    lateinit var binding: FragmentUpcomingBinding
//    var abapter = MovielistAdapter()

    var list = ArrayList<ResultsItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpcomingBinding.inflate(layoutInflater)
        abapter = MovielistAdapter()
        callAPI()
        return binding.root
    }

    private fun callAPI() {
        var api = APIClient.getapiclient().create(upcominginterface::class.java)

        api.getUpcomingmovie().enqueue(object : Callback<Movielistmodel> {

            override fun onResponse(
                call: Call<Movielistmodel>,
                response: Response<Movielistmodel>
            ) {
                if (response.isSuccessful) {
                    var movielist = response.body()?.results

                    list.addAll(movielist as ArrayList<ResultsItem>)

                    abapter.setmovie(list)

                    binding.rcv.layoutManager = LinearLayoutManager(context)
                    binding.rcv.adapter = abapter
                }

            }


            override fun onFailure(call: Call<Movielistmodel>, t: Throwable) {
            }

        })
    }


}