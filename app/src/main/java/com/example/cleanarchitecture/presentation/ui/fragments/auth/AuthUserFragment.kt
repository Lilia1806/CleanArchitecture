package com.example.cleanarchitecture.presentation.ui.fragments.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentAuthUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthUserFragment : Fragment(R.layout.fragment_auth_user) {

    private val binding by viewBinding(FragmentAuthUserBinding::bind)
    private val viewModel by viewModels<AuthUserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
    }

    private fun setupRequest() {
        binding.btnSignUp.setOnClickListener {
            if (binding.etName.text.toString() == "") {
                binding.etName.error = "Заполните поле!"
            } else if (binding.etSurname.text.toString() == "") {
                binding.etSurname.error = "Заполните поле!"
            } else if (binding.etAge.text.toString() == "") {
                binding.etAge.error = "Заполните поле!"
            } else {
                val name = binding.etName.text.toString().trim()
                val surname = binding.etSurname.text.toString().trim()
                val age = binding.etAge.text.toString().trim().toInt()
                viewModel.authUser(name, surname, age)
                findNavController().navigate(
                    AuthUserFragmentDirections.actionAuthUserFragmentToUserInformationFragment(
                        name, surname, age
                    )
                )
            }
        }
    }
}
