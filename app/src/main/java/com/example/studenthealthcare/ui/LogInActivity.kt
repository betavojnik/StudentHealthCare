package com.example.studenthealthcare.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.ActivityLogInBinding
import com.google.android.material.snackbar.Snackbar
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks

class LogInActivity : AppCompatActivity() {

     lateinit var binding : ActivityLogInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linkSetup()

    }

    private fun linkSetup() {

        val anotherActivity = Link("Register now!")
            .setTextColor(Color.BLUE)
            .setUnderlined(true)
            .setOnClickListener {
                 Intent(this, MainActivity::class.java).also {
                     startActivity(it)
                 }
            }

        binding.textView.applyLinks(anotherActivity)
    }
}