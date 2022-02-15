package com.example.test_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SquareActivity : LoggingActivity("Square activity") {
    lateinit var displayText: TextView

    var recivedValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)
        displayText = findViewById(R.id.squared_number)
        displayRecivedValue()
    }

    fun goToMainActivity (view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.COUNTER_VALUE_KEY, recivedValue)
        startActivity(intent)
    }

    fun displayRecivedValue(){
        recivedValue = intent.getIntExtra(MainActivity.COUNTER_VALUE_KEY, 0)
        displayText.text = (recivedValue * recivedValue).toString()
    }


}