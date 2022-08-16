package com.example.uadadvertisor.common

import okhttp3.logging.HttpLoggingInterceptor

object PreferencesConstants {

    const val KEY_TOKEN = "token"
    const val KEY_TOKEN_EXPIRATION_TIME = "tokenExpirationTime"
    const val KEY_TOKEN_TYPE = "tokenType"
}

object ApiConstants {
    const val BASE_URL = "https://app.uadapp.com/api/Adv/"
    const val AUTH_ENDPOINT = "X-Authorization/"
    const val ACCEPT = "Accept"
    const val ACCEPT_LANGUAGE = "Accept-Language"
}

object ApiParameters {
    const val TOKEN_TYPE = "Bearer "
    const val AUTH_HEADER = "Authorization"
    const val GRANT_TYPE_KEY = "grant_type"
    const val GRANT_TYPE_VALUE = "client_credentials"
    const val CLIENT_ID = "client_id"
    const val CLIENT_SECRET = "client_secret"

    const val PAGE = "page"
    const val LIMIT = "limit"
    const val LOCATION = "location"
    const val DISTANCE = "distance"
    const val NAME = "name"
    const val AGE = "age"
    const val TYPE = "type"
}

object InterceptorConstants {
    val loggingInterceptorConstant = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}