package com.example.xenya.navigationdrawer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MediaService : Service() {

    private val mBinder = MediaBinder()
    private var mMediaPlayer: MediaPlayer? = null
    private var songs = SongsHolder.songs
    private var positionNow: Int = 0

    inner class MediaBinder : Binder() {
        fun getService(): MediaService = this@MediaService
    }

    override fun onBind(intent: Intent): IBinder = mBinder

    fun play(position: Int) {
        positionNow = position
        mMediaPlayer?.stop()
        mMediaPlayer = MediaPlayer.create(this, songs[position].songId)
        mMediaPlayer?.start()
        mMediaPlayer?.setOnCompletionListener {
            next()
        }
    }

    fun isPlaying(): Boolean = mMediaPlayer?.isPlaying == true

    fun prev() {
        var prevPos = positionNow - 1
        if (prevPos < 0)
            prevPos = songs.size - 1

        play(prevPos)
    }

    fun next() {
        val nextPos = (positionNow + 1) % songs.size
        play(nextPos)
    }

    fun pause() = mMediaPlayer?.pause()

    fun resume() = mMediaPlayer?.start()

    fun stop() = mMediaPlayer?.stop()

    fun release() {
        mMediaPlayer?.release()
        mMediaPlayer = null
    }

    fun getPlayingSong(): Song = songs[positionNow]

    override fun onDestroy() {
        super.onDestroy()
        release()
    }
}
