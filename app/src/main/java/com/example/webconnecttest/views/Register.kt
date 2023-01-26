package com.example.webconnecttest.views

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.webconnecttest.R
import com.example.webconnecttest.databinding.ActivityRegisterBinding
import com.example.webconnecttest.databinding.OtpLayoutBinding
import com.example.webconnecttest.util.Common
import com.github.willena.phoneinputview.CountryConfigurator

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    companion object{
        private const val REGISTER_TIME_OUT = 3000
    }

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_toolbar_back)
        }

        binding.backToolbar.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val config = CountryConfigurator()
        config.apply {
            defaultCountry = "IN"
            displayFlag = true
            displayCountryCode = false
            phoneNumberHintType = CountryConfigurator.HintType.FIXED
            displayDialingCode = false
        }
        binding.phoneInput.config = config




        binding.btnRequestOtp.setOnClickListener {


            val phone = binding.phoneInput.formatedNumber


            val dialog = Dialog(this)


            val bindingDialog = OtpLayoutBinding.inflate(layoutInflater)

            dialog.setContentView(bindingDialog.root)

            if (!phone.isNullOrEmpty()){
                bindingDialog.txtDialogOtp1.text = phone.substring(4,5)
                bindingDialog.txtDialogOtp2.text = phone.substring(5,6)
                bindingDialog.txtDialogOtp3.text = phone.substring(13,14)
                bindingDialog.txtDialogOtp4.text = phone.substring(14,15)
                dialog.show()

                Handler(mainLooper).postDelayed({
                    startActivity(Intent(this, Otp::class.java))
                    dialog.dismiss()
                }, REGISTER_TIME_OUT.toLong())

                Common.phone = phone
                Common.otp = phone.substring(4,5)+phone.substring(5,6)+phone.substring(13,14)+phone.substring(14,15)
            }else{
                Toast.makeText(this,"Please Enter The Mobile Number", Toast.LENGTH_LONG).show()
            }







        }

    }
}