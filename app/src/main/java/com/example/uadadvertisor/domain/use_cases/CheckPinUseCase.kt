package com.example.uadadvertisor.domain.use_cases

import com.example.uadadvertisor.common.Resource
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PinBodyModel
import com.example.uadadvertisor.data.remote.dto.registerResponseDTO.toModel
import com.example.uadadvertisor.domain.model.RegisterResponse.RegisterResponse
import com.example.uadadvertisor.domain.reposetories.IRegistrationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CheckPinUseCase @Inject constructor(private val repository: IRegistrationRepository) {

    suspend fun checkPinUseCase(pin: PinBodyModel) : Flow<Resource<RegisterResponse>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.checkPin(pin).toModel()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        }
    }
}
