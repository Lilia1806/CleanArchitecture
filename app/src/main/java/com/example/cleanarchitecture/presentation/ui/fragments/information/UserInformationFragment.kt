package com.example.cleanarchitecture.presentation.ui.fragments.information

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.FragmentUserInformationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInformationFragment : Fragment(R.layout.fragment_user_information) {

    private val binding by viewBinding(FragmentUserInformationBinding::bind)
    private val args by navArgs<UserInformationFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()
    }

    private fun initialize() = with(binding) {
        tvName.isVisible = false
        tvSurname.isVisible = false
        tvAge.isVisible = false
        showData.isVisible = false
    }

    private fun setupListener() = with(binding) {
        binding.showData.setOnClickListener {
            tvName.isVisible = false
            tvSurname.isVisible = false
            tvAge.isVisible = false
            hideData.isVisible = true
            showData.isVisible = false
        }

        binding.hideData.setOnClickListener {
            tvName.isVisible = true
            tvSurname.isVisible = true
            tvAge.isVisible = true
            showData.isVisible = true
            hideData.isVisible = false
        }
    }

    private fun getData() {
        binding.tvName.text = args.name
        binding.tvAge.text = args.age.toString()
        binding.tvSurname.text = args.surname
    }
}
