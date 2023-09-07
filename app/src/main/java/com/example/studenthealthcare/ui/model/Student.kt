package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val StudentId : String,
    val Username : String,
    val Password : String,
    val Name: String,
    val Surname: String,
    val YearOfEnrollment: Int,
    val YearOfStudy: Int
) : Serializable