package com.example.studenthealthcare.ui.screens

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
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
            Student("1", "Nedeljko", "idegas", "neso", "babic", 2020,3),
            Student("2", "Marko", "Markovic", "neso", "babic", 2020,3)
        )
        val vaccines : List<Vaccine> = listOf(
            Vaccine("1", "AH1", 15)
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
                        val intent = Intent(requireActivity(), MainActivity::class.java)

                        // Add the logged-in Student as an extra to the Intent
                        intent.putExtra("loggedStudent", pronadjeni)

                        // Start MainActivity with the Intent
                        startActivity(intent)
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
                val targetFragment = RegisterFragment()

                val transaction = childFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, targetFragment) // Replace 'fragment_container' with your container view's ID
                transaction.addToBackStack(null) // Allow navigating back
                transaction.commit()
                }


        binding.textView.applyLinks(anotherActivity)
    }


}