package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val StudentId : String,
    val Name: String,
    val Surname: String,
    val YearOfEnrollment: Int,
    val YearOfStudy: Int
)