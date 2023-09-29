package com.example.movie.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object{

        var baseUrl = "https://api.themoviedb.org/3/movie/"
        var imgurl = "https://image.tmdb.org/t/p/w500"

        var token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZDY1ZDI3ODNlYzdhMmUyNzY0MDNjNDJjNWMwZWM3MSIsInN1YiI6IjY0YWFhODM1YjY4NmI5MDE1MDEwMTBhYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NQVwz87XsbFDFU7y8QkC3Tf12d7orprZkoo_5TiGZYs"
        var retrofit : Retrofit? = null

        fun getapiclient() :Retrofit {
            if (retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor { chain ->
                        val request = chain.request().newBuilder().addHeader("Authorization","Bearer ${token}").build()
                        chain.proceed(request)
                    }.build())
                    .build()
            }
            return retrofit!!
        }
    }
}