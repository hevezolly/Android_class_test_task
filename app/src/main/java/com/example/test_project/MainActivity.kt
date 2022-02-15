package com.example.test_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.math.max

class MainActivity : LoggingActivity("Main activity") {

    private lateinit var counterText : TextView
    private var counterValue = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterValue = savedInstanceState?.getInt(SAVE_KEY) ?:
            intent.getIntExtra(COUNTER_VALUE_KEY, 0)
        counterText = findViewById(R.id.configurationNum)
        counterText.text = counterValue.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (isChangingConfigurations)
            counterValue++
        outState.putInt(SAVE_KEY, counterValue)
        super.onSaveInstanceState(outState)
    }

    fun goToSquaredActivity (view: View) {
        val intent = Intent(this, SquareActivity::class.java)
        intent.putExtra(COUNTER_VALUE_KEY, counterValue)
        startActivity(intent)
    }

    companion object {
        const val COUNTER_VALUE_KEY = "counter_value"
        private const val SAVE_KEY = "key"
    }
}