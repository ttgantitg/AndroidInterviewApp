package com.ttgantitg.androidinterviewapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ttgantitg.androidinterviewapp.database.dao.*
import com.ttgantitg.androidinterviewapp.database.entities.*

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

//    companion object {
//        const val DATABASE_VERSION = 1
//        private const val DATABASE_NAME = "interview.db"
//        @Volatile private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context): AppDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
//            }
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(context.applicationContext,
//                AppDatabase::class.java, DATABASE_NAME)
//                .createFromAsset("databases/$DATABASE_NAME")
//                .build()
//    }