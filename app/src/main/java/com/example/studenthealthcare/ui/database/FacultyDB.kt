package com.example.studenthealthcare.ui.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.studenthealthcare.ui.dao.StudentDAO
import com.example.studenthealthcare.ui.model.Student
import com.example.studenthealthcare.ui.model.Vaccine
import com.example.studenthealthcare.ui.relations.StudentVaccineCrossRef

@Database(
    entities = [
        Student::class,
        Vaccine::class,
        StudentVaccineCrossRef::class
    ],
    version = 1
)
abstract  class FacultyDB : RoomDatabase(){

    abstract val studentDAO: StudentDAO

    companion object {
        private var INSTANCE: FacultyDB? = null
    }
}