package com.example.studenthealthcare.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studenthealthcare.R
import com.example.studenthealthcare.databinding.ProfileLayoutBinding

class RegisterFragment : Fragment(R.layout.profile_layout) {

    lateinit var binding : ProfileLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ProfileLayoutBinding.bind(view)




    }
}