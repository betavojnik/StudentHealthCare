package com.example.studenthealthcare.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
        @Volatile
        private var INSTANCE: FacultyDB? = null

        fun getInstance(context: Context) : FacultyDB {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    FacultyDB::class.java,
                    "faculty_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }

    }
}