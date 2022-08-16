package com.example.uadadvertisor.domain.model.RegisterResponse

import com.squareup.moshi.Json

data class Company(@Json(name = "commerical_number")
                   val commericalNumber: String = "",
                   @Json(name = "description")
                   val description: String = "",
                   @Json(name = "phone_number")
                   val phoneNumber: String = "")