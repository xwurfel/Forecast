package com.xwurfel.forecast.data

import com.xwurfel.forecast.domain.error_handling.AuthRepository
import com.xwurfel.forecast.domain.error_handling.DataError
import com.xwurfel.forecast.domain.error_handling.Result
import com.xwurfel.forecast.domain.error_handling.User
import retrofit2.HttpException

class AuthRepositoryImpl: AuthRepository {

    override suspend fun register(password: String): Result<User, DataError.Network> {
        //API call logic
        return try {
            val user = User("dummy", "dummy", "dummy")
            Result.Success(user)
        } catch (e: HttpException) {
            when(e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                503 -> Result.Error(DataError.Network.SERVER_ERROR)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        }
    }
}