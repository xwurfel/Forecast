package com.xwurfel.forecast.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coordinates")
data class Coordinates(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val latitude: Double,
    val longitude: Double,
)
