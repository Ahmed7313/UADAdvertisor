package com.example.uadadvertisor.domain.reposetories

import com.example.uadadvertisor.data.remote.dto.BaseResponseDTO
import com.example.uadadvertisor.data.remote.dto.BusinessCategoryModel.BusinessCategoryModelDTO
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CommercialNumberBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CompanyProfileBody
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PhoneBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PinBodyModel
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.RegisterResponseDTO
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Part

interface IRegistrationRepository {

    suspend fun checkPhoneNumber(phoneNumber: PhoneBodyModel): BaseResponseDTO

    suspend fun checkPin(pin: PinBodyModel): RegisterResponseDTO

    suspend fun createCompanyProfile (companyProfileBody: CompanyProfileBody) : RegisterResponseDTO

    suspend fun checkCommercialNumber(commercialNumberBodyModel: CommercialNumberBodyModel) : BaseResponseDTO

    suspend fun getBusinessCategories() : BusinessCategoryModelDTO

    suspend fun addYourBrand(name : RequestBody,
                             image : MultipartBody.Part,
                             categoryId : Array<Int>) : BaseResponseDTO

}