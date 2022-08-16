package com.example.uadadvertisor.domain.use_cases

import com.example.uadadvertisor.common.Resource
import com.example.uadadvertisor.data.remote.dto.ServieceBody.CompanyProfileBody
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.toModel
import com.example.uadadvertisor.domain.model.RegisterResponse.RegisterResponse
import com.example.uadadvertisor.domain.reposetories.IRegistrationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateCompanyProfileUseCase @Inject constructor(val repository: IRegistrationRepository) {

    suspend fun createCompanyProfile(companyProfileBody: CompanyProfileBody) : Flow<Resource<RegisterResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.createCompanyProfile(companyProfileBody).toModel()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        }
    }
}