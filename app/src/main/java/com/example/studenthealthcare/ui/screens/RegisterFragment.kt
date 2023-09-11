package com.example.studenthealthcare.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.ProfileLayoutBinding
import com.example.studenthealthcare.databinding.ReigsterLayoutBinding

class RegisterFragment : Fragment(R.layout.reigster_layout) {

    lateinit var binding : ReigsterLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ReigsterLayoutBinding.bind(view)




    }
}