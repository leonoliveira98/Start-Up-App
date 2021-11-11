package com.example.start_upapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_register.setOnClickListener {
            onRegisterClicked()
        }


        // Get spinner with options for the user to select
        val spinnerValues: Array<String> = arrayOf("Sr.", "Sra.")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_title.adapter = spinnerAdapter

    }

    private fun onRegisterClicked() {

        val data = Data (
            spinner_title.selectedItem?.toString(),
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone.text.toString(),
            edit_text_password.text.toString(),
        )



        val goDataActivity = Intent(this, DataActivity::class.java)
        goDataActivity.putExtra("Data", data)
        startActivity(goDataActivity)
    }
}