package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie.Adapter.fragmentlistAdapter
import com.example.movie.Fragment.NowPlayingFragment
import com.example.movie.Fragment.PopularFragment
import com.example.movie.Fragment.TopRatedFragment
import com.example.movie.Fragment.UpcomingFragment
import com.example.movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var item = arrayOf("NowPlaying","Upcoming","TopRated","Popular")
    var fragment = arrayOf(NowPlayingFragment(),UpcomingFragment(),TopRatedFragment(),PopularFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.adapter = fragmentlistAdapter(supportFragmentManager,fragment,item)
        binding.tablayout.setupWithViewPager(binding.viewpager)


    }
}