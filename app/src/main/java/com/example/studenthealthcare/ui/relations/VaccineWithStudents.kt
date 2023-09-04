package com.example.studenthealthcare.ui.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.studenthealthcare.ui.model.Student
import com.example.studenthealthcare.ui.model.Vaccine

data class VaccineWithStudents(
    @Embedded val Vaccine: Vaccine,
    @Relation(
        parentColumn = "VaccineId",
        entityColumn = "StudentId",
        associateBy = Junction(StudentVaccineCrossRef::class)
    )

    val students: List<Student>
)