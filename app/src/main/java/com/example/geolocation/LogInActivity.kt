package com.example.geolocation

import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LogInActivity : AppCompatActivity(){

    private var location : LocationManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enterButton.setOnClickListener{
            if (userName.text.isNotEmpty()){
                val intent = Intent(this@LogInActivity,MainActivity::class.java)
                intent.putExtra("username",userName.text.toString())
                startActivity(intent)
            }
        }

    }

}