package com.example.tvx4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tvx4.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    val URL ="https://arlocallive.lcdn.clarotv.com.ar/Content/HLS_HLS_FK/Live/channel(TELEFE)/index.m3u8"
    val URL1 ="https://arlocallive.lcdn.clarotv.com.ar/Content/HLS_HLS_FK/Live/channel(C5N)/index.m3u8"
    val URL2 ="https://arlocallive.lcdn.clarotv.com.ar/Content/HLS_HLS_FK/Live/channel(A24)/index.m3u8"
    val URL3 ="https://arlocallive.lcdn.clarotv.com.ar/Content/HLS_HLS_FK/Live/channel(ESPN)/index.m3u8"
    private var topRPlayer = ExoPlayerView(this,URL)
    private var topLPlayer = ExoPlayerView(this,URL1)
    private var bottomRPlayer = ExoPlayerView(this,URL2)
    private var bottomLPlayer = ExoPlayerView(this,URL3)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        topRPlayer.preparePlayer(binding.playerView)
        topLPlayer.preparePlayer(binding.playerView2)
        bottomRPlayer.preparePlayer(binding.playerView3)
        bottomLPlayer.preparePlayer(binding.playerView4)
    }


    override fun onStop() {
        super.onStop()
        topRPlayer.releasePlayer()
        topLPlayer.releasePlayer()
        bottomRPlayer.releasePlayer()
        bottomLPlayer.releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        topRPlayer.releasePlayer()
        topLPlayer.releasePlayer()
        bottomRPlayer.releasePlayer()
        bottomLPlayer.releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        topRPlayer.releasePlayer()
        topLPlayer.releasePlayer()
        bottomRPlayer.releasePlayer()
        bottomLPlayer.releasePlayer()
    }
}