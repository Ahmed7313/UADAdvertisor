package com.example.uadadvertisor.data.remote.dto.BusinessCategoryModel

import com.example.uadadvertisor.domain.model.BusinessCategoryModel.BusinessCategoryModel
import com.squareup.moshi.Json

data class BusinessCategoryModelDTO(@Json(name = "data")
                                    val data: List<DataItemDTO>?,
                                    @Json(name = "message")
                                    val message: String = "",
                                    @Json(name = "status")
                                    val status: Boolean = false)

fun BusinessCategoryModelDTO.toDomain(): BusinessCategoryModel {
    return BusinessCategoryModel(data?.map { it.toDomain() }, message, status)
}
