package com.example.users_add_delate_update


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersModel(
    val firstName:String,
    val lastName:String,
    val email:String
): Parcelable
