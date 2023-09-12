package com.example.studenthealthcare.ui.screens

import android.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.studenthealthcare.databinding.ReigsterLayoutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class RegisterFragment : Fragment(com.example.studenthealthcare.R.layout.reigster_layout) {

    lateinit var binding : ReigsterLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding = ReigsterLayoutBinding.bind(view)

        val navBar = requireActivity().findViewById<BottomNavigationView>(com.example.studenthealthcare.R.id.bottomNavigationView)
        navBar.visibility = View.GONE




    }
}