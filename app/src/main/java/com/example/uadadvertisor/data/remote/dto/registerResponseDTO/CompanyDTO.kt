package com.example.uadadvertisor.data.remote.dto.registerResponseDTO

import com.example.uadadvertisor.domain.model.RegisterResponse.Company
import com.squareup.moshi.Json

data class CompanyDTO(@Json(name = "commerical_number")
                   val commericalNumber: String = "",
                   @Json(name = "description")
                   val description: String = "",
                   @Json(name = "phone_number")
                   val phoneNumber: String = "")

    fun CompanyDTO.toDomain(): Company {
        return Company(commericalNumber, description, phoneNumber)
    }