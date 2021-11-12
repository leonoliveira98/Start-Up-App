package com.example.start_upapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {

    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        retrieveUser()
        displayUser()
        onClick()
    }

    private fun retrieveUser() {
        data = intent.getSerializableExtra("Data") as Data
    }

    private fun displayUser() {

        text_view_title.text = data.getFullName()
        text_view_email.text = "Email: ${data.email}"
        text_view_phone_number.text = "Phone Number: +351 ${data.phoneNumber}"
        text_view_password.text = "Password: ${data.password}"
    }

    private fun onClick() {

        text_view_phone_number.setOnClickListener{

            // Send Message Intent
            val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("tel: ${data.phoneNumber}" )  // This ensures only SMS apps respond
                startActivity(intent)


        }

        text_view_email.setOnClickListener{
            // Send Message Intent
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: ${data.email}") // only email apps should handle this
            startActivity(intent)
        }

    }
}