package com.example.uadadvertisor.data.remote.dto.registerResponseDTO

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.uadadvertisor.domain.model.RegisterResponse.Data
import com.squareup.moshi.Json
import java.time.Instant

data class DataDTO(@Json(name = "expire_at")
                val expireAt: Int? = 0,
                @Json(name = "check")
                val check: Int? = 0,
                @Json(name = "company")
                val company: CompanyDTO?,
                @Json(name = "user")
                val user: UserDTO?,
                @Json(name = "token")
                val token: String? = "")
{
    companion object {
        val INVALID = Data(
            0,
            -1,
            null,
            null,
            null)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Transient
    private val requestedAt: Instant = Instant.now()

    val expiresAt: Long
        @RequiresApi(Build.VERSION_CODES.O)
        get() {
            if (expireAt == null) return 0L

            return requestedAt.plusSeconds(expireAt.toLong()).epochSecond
        }

    fun isValid(): Boolean {
        return check != null && check != 0 &&
                expireAt != null && expireAt >= 0 &&
                token != null && token.isNotEmpty()
    }

}

fun DataDTO.toDomain(): Data? {
    return if (isValid()) {
        Data(
            expireAt = expireAt,
            company = company,
            user = user,
            token = token
        )
    } else {
        null
    }
}