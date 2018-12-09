package com.example.xenya.navigationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_song.view.*

class SongListAdapter(
        var listSong: List<Song>,
        var clickListener: (Int) -> Unit
) : RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder =
            SongViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false))

    override fun getItemCount(): Int = listSong.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = listSong[position]
        holder.bind(song)
        holder.itemView.setOnClickListener { clickListener(position) }
    }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(song: Song) {
            itemView.iv_song.setImageResource(song.imageId)
            itemView.tv_song_name.text = song.name
        }
    }
}
