package com.example.uadadvertisor.data.remote.dto.BusinessCategoryModel

import com.example.uadadvertisor.domain.model.BusinessCategoryModel.DataItem
import com.squareup.moshi.Json

data class DataItemDTO(@Json(name = "image")
                    val image: String = "",
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "id")
                    val id: Int = 0)

fun DataItemDTO.toDomain() : DataItem {
    return DataItem(image, name, id)
}