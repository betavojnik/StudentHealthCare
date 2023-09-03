package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true)
    val Id : String,
    val Name: String,
    val Surname: String,
    val YearOfEnrollment: String,
    val YearOfStudy: Int
)