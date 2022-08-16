package com.example.uadadvertisor.data.repository

import com.example.uadadvertisor.data.remote.ApiServieces.registrationApiServieces.RegistrationApiServieces
import com.example.uadadvertisor.data.remote.dto.BaseResponseDTO
import com.example.uadadvertisor.data.remote.dto.BusinessCategoryModel.BusinessCategoryModelDTO
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CommercialNumberBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CompanyProfileBody
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PhoneBodyModel
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PinBodyModel
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.RegisterResponseDTO
import com.example.uadadvertisor.domain.reposetories.IRegistrationRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    val services: RegistrationApiServieces
) : IRegistrationRepository {
    override suspend fun checkPhoneNumber(phoneNumber: PhoneBodyModel): BaseResponseDTO {
        return services.checkPhoneNumber(phoneNumber)
    }

    override suspend fun checkPin(pin: PinBodyModel): RegisterResponseDTO {
        return services.checkPin(pin)
    }

    override suspend fun createCompanyProfile(companyProfileBody: CompanyProfileBody): RegisterResponseDTO {
        return services.createCompanyProfile(companyProfileBody)
    }

    override suspend fun checkCommercialNumber(commercialNumberBodyModel: CommercialNumberBodyModel): BaseResponseDTO {
        return services.checkCommercialNumber(commercialNumberBodyModel)
    }

    override suspend fun getBusinessCategories(): BusinessCategoryModelDTO {
        return services.getBusinessCategories()
    }

    override suspend fun addYourBrand(
        name: RequestBody,
        image: MultipartBody.Part,
        categoryId: Array<Int>
    ): BaseResponseDTO {
        return services.addYourBrand(name, image, categoryId)
    }
}