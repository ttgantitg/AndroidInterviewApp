package com.ttgantitg.androidinterviewapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ttgantitg.androidinterviewapp.database.AppDatabase.Companion.DATABASE_VERSION
import com.ttgantitg.androidinterviewapp.database.entities.Java
import com.ttgantitg.androidinterviewapp.database.entities.Kotlin

@Database(entities = [Java::class, Kotlin::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "interview.db"
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset("databases/$DATABASE_NAME")
                .build()
    }
}