package com.example.uadadvertisor.data.remote.dto.registerResponseDTO

import com.example.uadadvertisor.domain.model.RegisterResponse.User
import com.squareup.moshi.Json

data class UserDTO(@Json(name = "role")
                val role: String = "",
                @Json(name = "phone")
                val phone: String = "",
                @Json(name = "name")
                val name: String? = null,
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "email")
                val email: String? = null)

fun UserDTO.toDomain() : User {
    return User(role,
        phone,
        name,
        id,
        email)
}