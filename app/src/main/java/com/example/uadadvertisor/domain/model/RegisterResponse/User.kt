package com.example.uadadvertisor.domain.model.RegisterResponse

import com.squareup.moshi.Json

data class User(@Json(name = "role")
                val role: String = "",
                @Json(name = "phone")
                val phone: String = "",
                @Json(name = "name")
                val name: String? = null,
                @Json(name = "id")
                val id: Int = 0,
                @Json(name = "email")
                val email: String? = null)