package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vaccine (
    @PrimaryKey(autoGenerate = true)
    val Id : String,
    val Name: String,
    val MonthsLast: Int
    )