package com.example.tvx4

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class ExoPlayer(private var context: Context, private var url: String) {

    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true
    private val trackSelector = DefaultTrackSelector(context).apply { setParameters(buildUponParameters().setMaxVideoSize(1919,1079)) }


    fun preparePlayer(binding: StyledPlayerView) {
        exoPlayer = ExoPlayer.Builder(context).setTrackSelector(trackSelector)
            .build()
        exoPlayer?.playWhenReady = true
        binding.player = exoPlayer
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        defaultHttpDataSourceFactory.setUserAgent("MAESDK")
        val mediaItem = MediaItem.fromUri(url)
        val mediaSource =
            HlsMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.volume = 0.2F
        exoPlayer?.prepare()
    }


    fun setVolume(value : Float){
        exoPlayer?.let { player ->
            player.volume = value
        }

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