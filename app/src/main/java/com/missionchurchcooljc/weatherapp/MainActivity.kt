package com.missionchurchcooljc.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import timber.log.Timber.DebugTree

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        to match the wireframe
//        hides the default supportActionBar associated with the Jetpack navigation
        val thisActivity = this
        thisActivity.supportActionBar?.hide()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}
