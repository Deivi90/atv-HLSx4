package com.example.tvx4

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.tvx4.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class ExoPlayerView(private var context: Context, private var url: String) {

    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true


    fun preparePlayer(binding: StyledPlayerView) {
        exoPlayer = ExoPlayer.Builder(context).build()
        exoPlayer?.playWhenReady = true
        binding.player = exoPlayer
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        defaultHttpDataSourceFactory.setUserAgent("MAESDK")
        val mediaItem = MediaItem.fromUri(url)
        val mediaSource =
            HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        //exoPlayer?.seekTo(playbackPosition)
        //exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.prepare()
    }

    fun releasePlayer(){
        exoPlayer?.let { player ->
            playbackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null
        }
    }

}