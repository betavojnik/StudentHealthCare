package com.example.studenthealthcare.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Vaccine (
    val Name: String,
    val MonthsLast: Int
    ) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var VaccineId: Int = 0 // or foodId: Int? = null
}