package com.example.cc17uielements

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.DatePicker.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_next.*
import java.util.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val fn = intent.getStringExtra("firstName")
        if (fn != null) {
            findViewById<TextView>(R.id.birthDateText).setText("Set your birthdate, $fn").toString()
        }

        val picker: DatePicker = findViewById<DatePicker>(R.id.birthDatePicker) as DatePicker
        var birthdate = "${picker.month+1}/${picker.dayOfMonth}/${picker.year}"
        picker.init(1999, 8, 1, object : DatePicker.OnDateChangedListener {
            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                birthdate = "${picker.month+1}/${picker.dayOfMonth}/${picker.year}"
            }
        })

        submitBdateBtn.setOnClickListener {
            var birth = birthdate.toString()
            val intent2 = Intent(this@NextActivity, UserProfile::class.java)
            intent2.putExtra("firstName", intent.getStringExtra("firstName"))
            intent2.putExtra("lastName", intent.getStringExtra("lastName"))
            intent2.putExtra("emailAdd", intent.getStringExtra("emailAdd"))
            intent2.putExtra("age", intent.getStringExtra("age"))
            intent2.putExtra("phoneNum", intent.getStringExtra("phoneNum"))
            intent2.putExtra("birthDate", birth)
            startActivity(intent2)
        }
    }
}
