package com.xwurfel.forecast.domain.error_handling

interface AuthRepository {
    suspend fun register (password: String): Result<User, DataError.Network>
}

data class User(
    val fullName: String,
    val token: String,
    val email: String
)