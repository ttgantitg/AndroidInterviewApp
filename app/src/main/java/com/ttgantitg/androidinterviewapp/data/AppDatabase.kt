package com.ttgantitg.androidinterviewapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ttgantitg.androidinterviewapp.data.dao.*
import com.ttgantitg.androidinterviewapp.data.entities.*

@Database(entities = [Java::class, Kotlin::class, Android::class, Libs::class, General::class],
    version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun javaDao(): JavaDao
    abstract fun kotlinDao(): KotlinDao
    abstract fun androidDao(): AndroidDao
    abstract fun libsDao(): LibsDao
    abstract fun generalDao(): GeneralDao
}

private const val DATABASE_VERSION = 1