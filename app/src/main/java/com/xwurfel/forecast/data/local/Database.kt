package com.xwurfel.forecast.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Coordinates::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun coordinatesDao(): CoordinatesDao

    companion object {
        private const val DATABASE_NAME = "forecast_db"

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return instance!!
        }
    }
}