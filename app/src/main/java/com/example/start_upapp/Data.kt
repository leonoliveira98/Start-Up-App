package com.example.start_upapp

import java.io.Serializable

data class Data(

    val title : String,
    val firstName : String,
    val lastName : String,
    val email : String,
    val phoneNumber : String,
    val password : String

) : Serializable {

    fun getFullName():String{
        return "$title $firstName $lastName"
    }

}