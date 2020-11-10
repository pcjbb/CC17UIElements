package com.example.cc17uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val fn = getIntent().getStringExtra("firstName")
        if (fn != null) {
            findViewById<TextView>(R.id.birthDateText).setText("Set your birthdate, $fn").toString()
        }
        findViewById<CalendarView>(R.id.birthDatePicker)
        findViewById<Button>(R.id.submitBdateBtn).setOnClickListener { submitBirthdate() }
    }
    private fun submitBirthdate(){

        goToUserProfile()

    }
    private fun goToUserProfile(){
        val intent = Intent(this, UserProfile::class.java)
        intent.putExtra("firstName", intent.getStringExtra("firstName"));
        intent.putExtra("lastName", intent.getStringExtra("lastName"));
        intent.putExtra("emailAdd", intent.getStringExtra("emailAdd"));
        intent.putExtra("age", intent.getStringExtra("age"));
        intent.putExtra("phoneNum", intent.getStringExtra("phoneNum"));
        //intent.putExtra("Birthdate", birth)
        startActivity(intent)
    }
}