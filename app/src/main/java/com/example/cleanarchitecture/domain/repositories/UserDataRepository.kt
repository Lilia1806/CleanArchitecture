package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.models.UserData


interface UserDataRepository {
    fun authUser(name : String, surname : String, age : Int)

    fun getUser() : UserData
}