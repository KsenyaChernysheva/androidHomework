package com.example.xenya.navigationdrawer

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity

open class ThemedAppCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getThemeFromPref())
    }

    @StyleRes
    private fun getThemeFromPref(): Int = when (
    PreferenceManager.getDefaultSharedPreferences(this)
            .getString("theme_preference", "")) {
        "AppTheme" -> R.style.AppTheme
        "AppThemeDark" -> R.style.AppThemeDark
        "AppThemeJojo" -> R.style.AppThemeJojo
        else -> R.style.AppTheme
    }
}
