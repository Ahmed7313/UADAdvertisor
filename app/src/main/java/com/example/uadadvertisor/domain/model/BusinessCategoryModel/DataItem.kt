package com.example.uadadvertisor.domain.model.BusinessCategoryModel

import com.squareup.moshi.Json

data class DataItem(@Json(name = "image")
                    val image: String = "",
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "id")
                    val id: Int = 0)