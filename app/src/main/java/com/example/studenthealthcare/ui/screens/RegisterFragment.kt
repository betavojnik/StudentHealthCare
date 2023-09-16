package com.example.studenthealthcare.ui.screens

import android.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.studenthealthcare.databinding.RegisterLayoutBinding
import com.example.studenthealthcare.ui.dao.StudentDAO
import com.example.studenthealthcare.ui.database.FacultyDB
import com.example.studenthealthcare.ui.model.Student
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class RegisterFragment : Fragment(com.example.studenthealthcare.R.layout.register_layout) {

    lateinit var binding : RegisterLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding = RegisterLayoutBinding.bind(view)
        val dao: StudentDAO = FacultyDB.getInstance(requireActivity()).studentDAO

        binding.registerButton.setOnClickListener {
            // Check if any of the EditText fields are empty
            val name = binding.editTextText.text.toString()
            val surname = binding.editTextText2.text.toString()
            val username = binding.editTextText3.text.toString()
            val password = binding.editTextText4.text.toString()
            val yearOfEnrollment = binding.editTextText5.text.toString().toInt()
            val yearofstudy = binding. editTextText6.text.toString().toInt()

            if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()         ) {
                // Display a Snackbar message if any field is empty
                Snackbar.make(view, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            } else {

                val student = Student(username,password,name,surname,yearOfEnrollment,yearofstudy)
                lifecycleScope.launch {
                    val students = dao.getStudentsWithUserAndPass(student.Username,student.Password)
                    if(students.isEmpty())
                    {
                        Snackbar.make(view, "Novi student", Snackbar.LENGTH_SHORT).show()
                    }
                    else {
                        Snackbar.make(view, "isto ime jbt", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }







    }
}