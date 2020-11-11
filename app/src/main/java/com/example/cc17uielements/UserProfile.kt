package com.example.cc17uielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val intent = getIntent()
        val fn = intent.getStringExtra("firstName")
        val ln = intent.getStringExtra("lastName")
        val a = intent.getStringExtra("age")
        val ea = intent.getStringExtra("emailAdd")
        val pn = intent.getStringExtra("phoneNum")
        val bd = intent.getStringExtra("birthDate")
        if (fn != null && ln != null && ea != null && a != null && pn != null) {
            fullName.setText("$fn $ln").toString()
            firstNameText.setText("First Name: $fn").toString()
            lastNameText.setText("Last Name: $ln").toString()
            ageText.setText("Age: $a").toString()
            emailText.setText("Email: $ea").toString()
            birthDateText.setText("Birthdate: $bd").toString()
            phoneNumberText.setText("Phone Number: $pn").toString()
        }

    }
}