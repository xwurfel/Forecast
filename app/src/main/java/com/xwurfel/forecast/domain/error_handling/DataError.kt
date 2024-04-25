package com.xwurfel.forecast.domain.error_handling

sealed interface DataError : Error {
    enum class Network: DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        PAYLOAD_TOO_LARGE,
        SERIALIZATION,
        NO_INTERNET,
        SERVER_ERROR,
        UNKNOWN
    }
    enum class Local: DataError {
        DISK_FULL
    }
}