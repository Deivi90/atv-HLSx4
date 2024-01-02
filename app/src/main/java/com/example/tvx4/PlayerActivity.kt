package com.example.tvx4

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tvx4.databinding.ActivityPlayerBinding

//Pantalla de Monitores
class PlayerActivity : FragmentActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private lateinit var topRPlayer : ExoPlayer
    private lateinit var topLPlayer : ExoPlayer
    private lateinit var bottomRPlayer : ExoPlayer
    private lateinit var bottomLPlayer : ExoPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val channelUrl = intent.getStringArrayExtra("url")!!
        topRPlayer = ExoPlayer(this, channelUrl[0])
        topLPlayer = ExoPlayer(this,channelUrl[1])
        bottomRPlayer = ExoPlayer(this,channelUrl[2])
        bottomLPlayer = ExoPlayer(this,channelUrl[3])
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
    }

    override fun onBackPressed() {
        super.onBackPressed()
        onDestroy()
    }

    override fun onDestroy() {
        super.onDestroy()
        topRPlayer.releasePlayer()
        topLPlayer.releasePlayer()
        bottomRPlayer.releasePlayer()
        bottomLPlayer.releasePlayer()
    }
}