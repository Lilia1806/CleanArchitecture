package com.example.data.dtos

import com.example.domain.models.User

data class UserDataDto(
    val name: String,
    val surname: String,
    val age: Int
)

fun UserDataDto.toDomain(): User {
    return User(name, surname, age)
}