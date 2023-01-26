package com.example.webconnecttest.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.webconnecttest.R

class MainActivity : AppCompatActivity() {

    companion object{
        private const val SPLASH_TIME_OUT = 2000
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, GetStarted::class.java))
            finish()
        }, SPLASH_TIME_OUT.toLong())

    }
}