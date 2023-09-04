package com.example.studenthealthcare.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.ActivityLogInBinding
import com.example.studenthealthcare.ui.dao.StudentDAO
import com.example.studenthealthcare.ui.database.FacultyDB
import com.example.studenthealthcare.ui.model.Student
import com.example.studenthealthcare.ui.model.Vaccine
import com.google.android.material.snackbar.Snackbar
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import kotlinx.coroutines.launch

class LogInActivity : AppCompatActivity() {

     lateinit var binding : ActivityLogInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao: StudentDAO = FacultyDB.getInstance(this).studentDAO

        val students : List<Student> = listOf(
            Student("1", "Nedeljko", "Babic", 2020, 3),
            Student("2", "Marko", "Markovic", 2020, 3)
        )

        val vaccines : List<Vaccine> = listOf(
            Vaccine("1", "AH1", 15)
        )



        lifecycleScope.launch {
            students.forEach{ dao.insertStudent(it)}
            vaccines.forEach{ dao.insertVaccine(it)}
        }

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