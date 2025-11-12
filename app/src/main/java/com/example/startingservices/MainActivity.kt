package com.example.startingservices // <-- Make sure this matches your project's package name

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCountdown = findViewById<EditText>(R.id.editTextCountdown)
        val buttonStartService = findViewById<Button>(R.id.buttonStartService)

        buttonStartService.setOnClickListener {
            val text = editTextCountdown.text?.toString()?.trim()
            val seconds = text?.toIntOrNull()

            if(seconds== null || seconds < 0 ){
                Log.i("MainActivity", "Invalid Text")
                editTextCountdown.error = "please enter a non-negative Int"
                return@setOnClickListener
            }
//            startCountdown()

            val intent = Intent(this, CountdownService::class.java)
                .putExtra(CountdownService.EXTRA_SECONDS, seconds)
            startService(intent)
        }
    }

}