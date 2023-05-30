package com.example.presentation.ui.fragments.information

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserInformationViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    fun getUser() = getUserUseCase()
}