package com.example.studenthealthcare.ui.screens

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.LoginLayoutBinding
import com.example.studenthealthcare.databinding.ProfileLayoutBinding
import com.example.studenthealthcare.ui.dao.StudentDAO
import com.example.studenthealthcare.ui.database.FacultyDB
import com.example.studenthealthcare.ui.model.Student
import com.example.studenthealthcare.ui.model.Vaccine
import com.example.studenthealthcare.ui.relations.StudentVaccineCrossRef
import com.google.android.material.snackbar.Snackbar
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment :  Fragment(R.layout.login_layout) {

    lateinit var binding: LoginLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = LoginLayoutBinding.bind(view)

        val dao: StudentDAO = FacultyDB.getInstance(requireActivity()).studentDAO
        val students : List<Student> = listOf(
            Student("peki", "peki123", "Petar", "Petrovic", 2020, 3),
            Student("zeki", "zeki123", "Zvezdan", "Jovanovic", 2019, 4)
        )
        val vaccines : List<Vaccine> = listOf(
            Vaccine("AH12", 5)
        )

        val ref : List<StudentVaccineCrossRef> = listOf(
            StudentVaccineCrossRef("2", "1")
        )



        lifecycleScope.launch {

                students.forEach { dao.insertStudent(it) }
                vaccines.forEach { dao.insertVaccine(it) }
                ref.forEach { dao.insertStudentVaccineCrossRef(it) }

        }


        linkSetup()

        binding.loginButton.setOnClickListener {

            if(binding.usernameEditText.text.toString().isNullOrEmpty()) {
                Snackbar.make(binding.root, "Prazno je", Snackbar.LENGTH_LONG).show()
            }
            else {
                lifecycleScope.launch {
                    val pronadjeni = dao.getStudentByName(binding.usernameEditText.text.toString())
                    if (pronadjeni != null) {


                        val bundle = Bundle().apply {
                            putSerializable("loggedStudent", pronadjeni)
                        }


                        findNavController().navigate(
                            R.id.action_loginFragment_to_profileFragment,
                            bundle
                        )
                    }
                }
            }
        }

    }

    private fun linkSetup() {

        val anotherActivity = Link("Register now!")
            .setTextColor(Color.BLUE)
            .setUnderlined(true)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_loginFragment_to_registerFragment,



                )
                }


        binding.textView.applyLinks(anotherActivity)
    }


}