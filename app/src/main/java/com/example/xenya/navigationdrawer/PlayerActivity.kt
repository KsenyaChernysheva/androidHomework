package com.example.xenya.navigationdrawer

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    companion object {
        const val KEY_POSITION = "position"

        fun getIntentForPlay(position: Int, context: Context): Intent {
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra(KEY_POSITION, position)
            return intent
        }
    }

    var mService: MediaService? = null
    var mBound = false
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        position = intent.getIntExtra(KEY_POSITION, 0)


        iv_rewind.setOnClickListener {
            mService?.prev()
            fillData()
        }

        iv_pp.setOnClickListener {
            if (mService?.isPlaying() == true) {
                mService?.pause()
            } else {
                mService?.resume()
            }
            fillData()
        }

        iv_stop.setOnClickListener {
            mService?.stop()
            fillData()
        }

        iv_forward.setOnClickListener {
            mService?.next()
            fillData()
        }

        val intent = Intent(this, MediaService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MediaService::class.java)
        bindService(intent, mConnection, 0)
    }

    override fun onStop() {
        super.onStop()
        if (mBound) {
            unbindService(mConnection)
            mBound = false
        }
    }

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as MediaService.MediaBinder
            mService = binder.getService()
            mBound = true
            if (mService?.isPlaying() == false)
                mService?.play(position)
            fillData()
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    private fun fillData() {
        if (mBound) {
            mService?.let {
                val song = it.getPlayingSong()
                iv_song.setImageResource(song.imageId)
                tv_song_name.text = song.name
                iv_pp.setImageResource(
                        if (it.isPlaying())
                            R.drawable.ic_pause_black_24dp
                        else
                            R.drawable.ic_play_arrow_black_24dp)
            }
        }
    }
}
