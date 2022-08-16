package com.example.uadadvertisor.domain.use_cases

import com.example.uadadvertisor.common.Resource
import com.example.uadadvertisor.data.remote.dto.BaseResponseDTO
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PhoneBodyModel
import com.example.uadadvertisor.data.remote.dto.toDomain
import com.example.uadadvertisor.data.repository.RegistrationRepository
import com.example.uadadvertisor.domain.model.BaseResponse
import com.example.uadadvertisor.domain.reposetories.IRegistrationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class CheckPhoneUseCase @Inject constructor(private val repository: IRegistrationRepository) {

    fun checkPhone(phoneBodyModel: PhoneBodyModel) : Flow<Resource<BaseResponse>> = flow{
        emit(Resource.Loading())
        try {
            val response = repository.checkPhoneNumber(phoneBodyModel).toDomain()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        } catch (e : HttpException) {
            if (e.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                emit(Resource.Error("Phone Number Not Found!"))
            } else {
                emit(Resource.Error("Error Occurred!"))
            }
        } catch (e : IOException){
            emit(Resource.Error("Failed to connect to server! check you internet connection!"))
        }
   }
   }

