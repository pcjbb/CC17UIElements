package com.example.cc17uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup = findViewById<Button>(R.id.goToNextBtn)
        val firstName = findViewById<EditText>(R.id.firstNameEditText).text.toString()
        val lastName = findViewById<EditText>(R.id.lastNameEditText).text.toString()
        val emailAdd = findViewById<EditText>(R.id.emailEditText).text.toString()
        val age = findViewById<TextView>(R.id.displayAge).text.toString()
        val phoneNum = findViewById<EditText>(R.id.phoneNumEditText).text.toString()

        findViewById<Switch>(R.id.phoneNumSwitch).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                phoneNumEditText.visibility = View.VISIBLE
                val phoneNumber = phoneNumEditText.text.toString()
            } else {
                phoneNumEditText.visibility = View.INVISIBLE
            }
        }

        findViewById<SeekBar>(R.id.ageSeekBar).setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                if (p0 != null) {
                    displayAge.setText("${p0.progress}").toString()
                }
            }
        })
        signup.setOnClickListener {
            if (firstName == null || lastName == null || emailAdd == null || age == null) {
                Toast.makeText(this, "Please fill up all fields", Toast.LENGTH_SHORT).show()
            } else {
                goToNextActivity()
            }
        }
    }

    private fun goToNextActivity() {
        val intent = Intent(this, NextActivity::class.java)
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val emailAdd = emailEditText.text.toString()
        val age = displayAge.text.toString()
        val phoneNum = phoneNumEditText.toString()
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("emailAdd", emailAdd)
        intent.putExtra("age", age)
        intent.putExtra("phoneNum", phoneNum)
        startActivity(intent)
    }

    }
