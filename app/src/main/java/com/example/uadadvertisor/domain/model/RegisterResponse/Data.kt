package com.example.uadadvertisor.domain.model.RegisterResponse

import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.CompanyDTO
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.UserDTO
import com.squareup.moshi.Json

data class Data(@Json(name = "expire_at")
                val expireAt: Int? = 0,
                @Json(name = "check")
                val check: Int? = 0,
                @Json(name = "company")
                val company: CompanyDTO?,
                @Json(name = "user")
                val user: UserDTO?,
                @Json(name = "token")
                val token: String? = "")