package com.example.uadadvertisor.domain.model.RegisterResponse

import com.squareup.moshi.Json

data class RegisterResponse(@Json(name = "data")
                            val data: Data?,
                            @Json(name = "message")
                            val message: String = "",
                            @Json(name = "status")
                            val status: Boolean = false)