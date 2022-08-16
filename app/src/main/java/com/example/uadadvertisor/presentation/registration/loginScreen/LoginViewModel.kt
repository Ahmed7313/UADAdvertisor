package com.example.uadadvertisor.presentation.registration.loginScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uadadvertisor.common.Resource
import com.example.uadadvertisor.data.remote.dto.ServieceBody.PhoneBodyModel
import com.example.uadadvertisor.domain.use_cases.CheckPhoneUseCase
import com.example.uadadvertisor.presentation.registration.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: CheckPhoneUseCase
)  : ViewModel() {

    private val _state = mutableStateOf(ResponseState())
    val state : State<ResponseState> = _state

    fun checkPhone(phone: String)  : Boolean{
        val body = PhoneBodyModel(phone.trim())

        loginUseCase.checkPhone(body).onEach { response ->
            when (response) {
                is Resource.Success -> {
                    _state.value = ResponseState(isSuccess = response.data?.status ?: false)
                    Log.v("LoginViewModel", "checkPhone: ${response.data?.status}")
                }
                is Resource.Error -> {
                    _state.value = ResponseState(isError = response.message ?: "UnExpected Error")
                    Log.v("LoginViewModel", "checkPhone: ${response.message}")
                }
                is Resource.Loading -> {
                    _state.value = ResponseState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
        return _state.value.isSuccess
        }
    }

