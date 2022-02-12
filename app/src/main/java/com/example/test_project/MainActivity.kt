package com.example.test_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : LoggingActivity("Main activity") {

    private lateinit var counterText : TextView
    private var counterValue = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterValue = intent.getIntExtra(COUNTER_VALUE, 0)
        counterText = findViewById(R.id.configurationNum)
        counterText.text = counterValue.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SAVE_KEY, counterValue)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counterValue = savedInstanceState.getInt(SAVE_KEY) + 1
        counterText.text = counterValue.toString()
    }

    fun onButtonPress (view: View) {
        val intent = Intent(this, SquareActivity::class.java)
        intent.putExtra(COUNTER_VALUE, counterValue)
        startActivity(intent)
    }

    companion object {
        const val COUNTER_VALUE = "counter_value"
        private const val SAVE_KEY = "key"
    }
}