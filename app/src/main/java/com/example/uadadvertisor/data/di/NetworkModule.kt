package com.example.uadadvertisor.data.di

import com.example.uadadvertisor.common.ApiConstants
import com.example.uadadvertisor.common.ApiConstants.BASE_URL
import com.example.uadadvertisor.common.InterceptorConstants.loggingInterceptorConstant
import com.example.uadadvertisor.data.remote.ApiServieces.registrationApiServieces.RegistrationApiServieces
import com.example.uadadvertisor.data.repository.RegistrationRepository
import com.example.uadadvertisor.domain.reposetories.IRegistrationRepository
import com.example.uadadvertisor.domain.use_cases.CheckPhoneUseCase
import com.raywenderlich.android.petsave.common.data.api.interceptors.AuthenticationInterceptor
import com.raywenderlich.android.petsave.common.data.api.interceptors.LoggingInterceptor
import com.raywenderlich.android.petsave.common.data.api.interceptors.NetworkStatusInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideRegistrationApi(builder: Retrofit.Builder): RegistrationApiServieces {
        return builder
            .build()
            .create(RegistrationApiServieces::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        networkStatusInterceptor: NetworkStatusInterceptor,
        authenticationInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkStatusInterceptor)
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(loggingInterceptor)

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    fun provideRegistrationRepository(api: RegistrationApiServieces): IRegistrationRepository {
        return RegistrationRepository(api)
    }

    @Provides
    fun provideLoginUseCase(repository: IRegistrationRepository): CheckPhoneUseCase {
        return CheckPhoneUseCase(repository)
    }

}

