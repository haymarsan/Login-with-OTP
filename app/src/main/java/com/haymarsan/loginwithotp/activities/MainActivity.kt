package com.haymarsan.loginwithotp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.haymarsan.loginwithotp.R
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO
import com.haymarsan.loginwithotp.utils.PreferenceUtils
import com.haymarsan.loginwithotp.viewmodel.ViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

   lateinit var myViewModel: ViewModelImpl

    companion object{
        fun newInstance(context: Context): Intent{
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(ViewModelImpl::class.java)

        myViewModel.getOauthKeyFromRepo(userName = "KBZONBO", password = "!ad@Pi17", grantType = "password").observe(this, Observer {

            PreferenceUtils.saveData(this, "AuthToken", it.access_token)
            Log.d("AccessToken", it.access_token)
        })


        var otp = (0..999999).shuffled().first()

        btnGetCode.setOnClickListener {

            val authKey = "bearer ${PreferenceUtils.loadData(this, "AuthToken")}"
            val sms = SmsBodyVO("MGATE", editText.toString(), "Your OTP is ${otp}", SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date()), "ONB")
            myViewModel.getSMSFromRepo(authKey, sms).observe(this, Observer {

                Toast.makeText(this, "OTP Successfully Sent Out!", Toast.LENGTH_SHORT).show()
            })
        }

    }
}
