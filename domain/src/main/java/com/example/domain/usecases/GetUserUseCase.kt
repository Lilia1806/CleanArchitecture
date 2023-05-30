package com.example.domain.usecases

import com.example.domain.repositories.UserDataRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository
) {
    operator fun invoke() = userDataRepository.getUser()
}