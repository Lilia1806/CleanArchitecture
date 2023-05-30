package com.example.presentation.ui.fragments.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAuthUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                viewLifecycleOwner.lifecycleScope.launch {
                    delay(2000)
                    viewModel.getUser().apply {
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
    }
}
