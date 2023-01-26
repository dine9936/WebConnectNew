package com.example.webconnecttest.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.webconnecttest.R
import com.example.webconnecttest.databinding.ActivityOtpBinding
import com.example.webconnecttest.util.Common

class Otp : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_toolbar_back)
        }

        binding.backToolbar.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.txtOtpPhone.text = Common.phone
        binding.btnOtpSubmit.setOnClickListener {
            val otp = binding.otpView.otp
            if (otp.equals(Common.otp)){
                startActivity(Intent(this, CreateProfile::class.java))
                finish()
            }else{
                Toast.makeText(this,"Invalid OTP", Toast.LENGTH_LONG).show()
            }
        }
    }
}