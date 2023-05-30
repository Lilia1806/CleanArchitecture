package com.example.presentation.ui.fragments.auth

import androidx.lifecycle.ViewModel
import com.example.domain.models.User
import com.example.domain.usecases.AuthUserUseCase
import com.example.domain.usecases.GetUserUseCase
import com.example.presentation.models.UserUI
import com.example.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthUserViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    fun authUser(name: String, surname: String, age: Int) {
        authUserUseCase(name, surname, age)
    }

    fun getUser(): User {
        return getUserUseCase().toUI()
    }
}