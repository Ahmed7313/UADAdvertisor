package com.example.uadadvertisor.data.remote.ApiServieces.registrationApiServieces

import com.example.uadadvertisor.data.remote.dto.BaseResponseDTO
import com.example.uadadvertisor.data.remote.dto.BusinessCategoryModel.BusinessCategoryModelDTO
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CommercialNumberBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CompanyProfileBody
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PhoneBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PinBodyModel
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.RegisterResponseDTO
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface RegistrationApiServieces {

    @POST("checkPhone")
    suspend fun checkPhoneNumber(@Body model: PhoneBodyModel) : BaseResponseDTO

    @Multipart
    @POST("brand")
    suspend fun addYourBrand (
        @Part("name") name : RequestBody,
        @Part image : MultipartBody.Part,
        @Part("category_id[]") categoryId : Array<Int>
    ) : BaseResponseDTO

    @POST("verify_comerica_number")
    suspend fun checkCommercialNumber(
        @Body commercialNumberBodyModel: CommercialNumberBodyModel
    ) : BaseResponseDTO

    @POST("checkPin")
    suspend fun checkPin(@Body model: PinBodyModel) : RegisterResponseDTO

    @POST("createCompanyProfile")
    suspend fun createCompanyProfile (@Body companyProfileBody: CompanyProfileBody) : RegisterResponseDTO

    @GET("businessCategory")
    suspend fun getBusinessCategories() : BusinessCategoryModelDTO

}