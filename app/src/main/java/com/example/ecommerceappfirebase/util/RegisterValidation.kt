package com.example.ecommerceappfirebase.util

// this class help to prevent wrong register!
sealed class RegisterValidation(){
    object Success: RegisterValidation()
    data class Failed(val message: String): RegisterValidation()
}

data class RegisterFieldsStates(
    val email: RegisterValidation,
    val password: RegisterValidation
)
