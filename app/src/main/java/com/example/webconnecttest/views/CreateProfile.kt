package com.example.webconnecttest.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webconnecttest.R
import com.example.webconnecttest.databinding.ActivityCreateProfileBinding

class CreateProfile : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_toolbar_back)
        }

        binding.backToolbar.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


}