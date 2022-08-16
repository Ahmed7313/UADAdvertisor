package com.example.uadadvertisor.domain.model.BusinessCategoryModel

import com.squareup.moshi.Json

data class BusinessCategoryModel(@Json(name = "data")
                                 val data: List<DataItem>?,
                                 @Json(name = "message")
                                 val message: String = "",
                                 @Json(name = "status")
                                 val status: Boolean = false)