package com.example.uadadvertisor.data.remote.dto.registerResponseDTO

import com.example.uadadvertisor.domain.model.RegisterResponse.RegisterResponse
import com.squareup.moshi.Json

data class RegisterResponseDTO(@Json(name = "data")
                            val data: DataDTO?,
                            @Json(name = "message")
                            val message: String = "",
                            @Json(name = "status")
                            val status: Boolean = false)

fun RegisterResponseDTO.toModel(): RegisterResponse {
    return RegisterResponse(
        data?.toDomain(),
        message,
        status
    )
}