package com.xwurfel.forecast.domain.usecase

import com.xwurfel.forecast.data.local.AppDatabase
import javax.inject.Inject

class GetCoordinatesFromDatabase @Inject constructor(
    private val database: AppDatabase,
) {
    suspend operator fun invoke() = database.coordinatesDao().getLastCoordinates()
}