package com.ttgantitg.androidinterviewapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Kotlin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun kotlinDao(): KotlinDao
}