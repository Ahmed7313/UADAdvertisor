package com.example.uadadvertisor.data.remote.dto.ServieceBody

import android.net.Uri
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhoneBodyModel(val phone: String)

@JsonClass(generateAdapter = true)
data class CommercialNumberBodyModel(val commerical_number: String)

@JsonClass(generateAdapter = true)
data class PinBodyModel(val phone: String,
                        val code : String)

@JsonClass(generateAdapter = true)
data class CompanyProfileBody(val phone: String,
                              val name : String,
                              val description : String,
                              val commerical_number : String,
                              val phone_number : String)

@JsonClass(generateAdapter = true)
data class AddBrandBody(val name: String,
                        val image : Uri,
                        val category_id : Array<Int>)