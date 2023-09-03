package com.example.studenthealthcare.ui.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.studenthealthcare.ui.model.Student

data class StudentWithVaccines (
    @Embedded val Student: Student,
    @Relation(
        parentColumn = "StudentId",
        entityColumn = "VaccineId",
        associateBy = Junction(StudentVaccineCrossRef::class)
    )

    val students: List<Student>
)