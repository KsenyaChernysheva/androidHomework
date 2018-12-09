package com.example.xenya.navigationdrawer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songs = SongsHolder.songs

        rv_songs.adapter = SongListAdapter(songs) {
            startActivity(PlayerActivity.getIntentForPlay(it, this))
        }
    }
}
