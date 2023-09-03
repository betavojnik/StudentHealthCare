package com.example.studenthealthcare.ui.relations

import androidx.room.Entity

@Entity(primaryKeys = ["StudentId,VaccineId"])
data class StudentVaccineCrossRef (

    val StudentId: String,
    val VaccineId: String

)
