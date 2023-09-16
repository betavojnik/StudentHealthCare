package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Student(
    val Username : String,
    val Password : String,
    val Name: String,
    val Surname: String,
    val YearOfEnrollment: Int,
    val YearOfStudy: Int
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var StudentId: Int = 0 // or foodId: Int? = null
}