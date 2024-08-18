package com.xwurfel.forecast.domain.usecase

import com.xwurfel.forecast.data.local.AppDatabase
import com.xwurfel.forecast.data.local.Coordinates
import javax.inject.Inject

class SaveCoordinatesToDatabaseUseCase @Inject constructor(
    private val database: AppDatabase,
) {
    suspend operator fun invoke(coordinates: Coordinates) {
        database.coordinatesDao().upsertCoordinates(coordinates)
    }
}