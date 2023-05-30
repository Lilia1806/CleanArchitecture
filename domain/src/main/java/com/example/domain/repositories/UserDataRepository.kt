package com.example.domain.repositories

import com.example.domain.models.User


interface UserDataRepository {
    fun authUser(name : String, surname : String, age : Int)

    fun getUser() : User
}