package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.domain.repositories.UserDataRepository
import com.example.cleanarchitecture.data.local.preferences.UserDataPreferencesHelper
import com.example.cleanarchitecture.models.UserData
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userDataPreferencesHelper: UserDataPreferencesHelper
) : UserDataRepository {
    override fun authUser(name: String, surname: String, age: Int) {
        userDataPreferencesHelper.name = name
        userDataPreferencesHelper.surname = surname
        userDataPreferencesHelper.age = age

    }

    override fun getUser() = UserData(
        userDataPreferencesHelper.name.toString(),
        userDataPreferencesHelper.surname.toString(),
        userDataPreferencesHelper.age
    )

}