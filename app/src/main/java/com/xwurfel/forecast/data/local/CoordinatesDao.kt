package com.xwurfel.forecast.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CoordinatesDao {
    @Upsert
    suspend fun upsertCoordinates(coordinates: Coordinates)

    @Query("SELECT * FROM coordinates")
    suspend fun getCoordinates(): List<Coordinates>

    @Delete
    suspend fun deleteCoordinates(coordinates: Coordinates)

    @Query("SELECT * FROM coordinates ORDER BY id DESC LIMIT 1")
    suspend fun getLastCoordinates(): Coordinates
}