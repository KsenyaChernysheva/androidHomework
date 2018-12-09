package com.example.xenya.navigationdrawer

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Song(var name: String,
                @RawRes
                var songId: Int,
                @DrawableRes
                var imageId: Int)
