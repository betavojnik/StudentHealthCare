package com.example.studenthealthcare.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.ActivityLogInBinding
import com.example.studenthealthcare.databinding.ActivityMainBinding
import com.example.studenthealthcare.ui.model.Student

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding : ActivityMainBinding

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loggedStudent = intent.getSerializableExtra("loggedStudent") as Student?

        // Now you have access to the logged-in Student object

    }
}