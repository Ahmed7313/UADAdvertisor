package com.example.uadadvertisor.data.remote.dto

import com.example.uadadvertisor.domain.model.BaseResponse
import com.squareup.moshi.Json

data class BaseResponseDTO(@Json(name = "data")
                        val data: String = "",
                        @Json(name = "message")
                        val message: String = "",
                        @Json(name = "status")
                        val status: Boolean = false)

fun BaseResponseDTO.toDomain () : BaseResponse {
    return BaseResponse(data, message, status)
}