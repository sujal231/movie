package com.example.movie.API

import com.example.movie.Modelclass.Movielistmodel
import retrofit2.Call
import retrofit2.http.GET

interface topratedinterface {

    @GET("top_rated")
    fun gettopratedmovie() :Call<Movielistmodel>
}
