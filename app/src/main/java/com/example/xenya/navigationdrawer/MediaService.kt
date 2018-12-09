package com.example.xenya.navigationdrawer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MediaService : Service() {

    private val mBinder = MediaBinder()
    private var mMediaPlayer: MediaPlayer? = null
    private var songs = SongsHolder.songs
    private var positionNow: Int = 0

    companion object {
        const val CHANNEL_ID = "JoJO"
    }

    inner class MediaBinder : Binder() {
        fun getService(): MediaService = this@MediaService
    }

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_LOW
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ave)
                .setContentText("Service")
                .build()

        startForeground(1, notification)
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
        stopForeground(true)
    }
}
