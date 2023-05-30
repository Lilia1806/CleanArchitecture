package com.example.presentation.models

import android.os.Parcelable
import com.example.domain.models.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserUI(
    val name: String,
    val surname: String,
    val age: Int
) : Parcelable

fun User.toUI(): User {
    return User(name, surname, age)
}
