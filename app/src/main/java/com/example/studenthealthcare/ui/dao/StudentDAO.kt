package com.example.studenthealthcare.ui.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.studenthealthcare.ui.model.Student
import com.example.studenthealthcare.ui.model.Vaccine
import com.example.studenthealthcare.ui.relations.StudentVaccineCrossRef
import com.example.studenthealthcare.ui.relations.StudentWithVaccines
import com.example.studenthealthcare.ui.relations.VaccineWithStudents

@Dao
interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVaccine(vaccine: Vaccine)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentVaccineCrossRef(crossRef: StudentVaccineCrossRef)

    @Transaction
    @Query("SELECT * FROM vaccine WHERE VaccineId = :vaccineId ")
    suspend fun getStudentsForVaccine(vaccineId: String): List<VaccineWithStudents>
    @Transaction
    @Query("SELECT * FROM student WHERE  StudentId= :StudentId ")
    suspend fun getVaccinesForStudent(StudentId: String): List<StudentWithVaccines>
}