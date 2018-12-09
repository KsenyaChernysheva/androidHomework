package com.example.xenya.navigationdrawer

class SongsHolder {
    companion object {
        val songs: List<Song> by lazy {
            val s = ArrayList<Song>()
            s.add(Song("vas", R.raw.vas, R.drawable.ave))
            s.add(Song("Rich бахатый", R.raw.rich, R.drawable.el))
            s
        }
    }
}
