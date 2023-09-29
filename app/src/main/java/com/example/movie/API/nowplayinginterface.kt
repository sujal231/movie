package com.example.movie.API

import com.example.movie.Modelclass.Movielistmodel
import retrofit2.Call
import retrofit2.http.GET

interface nowplayinginterface {

    @GET("now_playing")
    fun getnowplayingmovie() :Call<Movielistmodel>
}