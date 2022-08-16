package com.example.uadadvertisor.domain.model

import com.squareup.moshi.Json

data class BaseResponse(@Json(name = "data")
                        val data: String = "",
                        @Json(name = "message")
                        val message: String = "",
                        @Json(name = "status")
                        val status: Boolean = false)