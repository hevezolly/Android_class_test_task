package com.example.test_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class LoggingActivity(val activityTag: String) : AppCompatActivity() {
    fun log(message: String){
        Log.d(activityTag,"$message. Current state: ${lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        log("on save instance state called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("on create called")
    }

    override fun onStart() {
        super.onStart()
        log("on start called")
    }

    override fun onResume() {
        super.onResume()
        log("on resume called")
    }

    override fun onPause() {
        super.onPause()
        log("on pause called")
    }

    override fun onStop() {
        super.onStop()
        log("on stop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("on destroy called")
    }
}