package com.example.xenya.navigationdrawer

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ThemedAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songs = SongsHolder.songs

        rv_songs.adapter = SongListAdapter(songs) {
            startActivity(PlayerActivity.getIntentForPlay(it, this))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_settings) {
            startActivity(Intent(this, PreferenceActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
